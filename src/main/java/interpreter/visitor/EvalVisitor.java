package interpreter.visitor;

import interpreter.Table;
import interpreter.Util;
import interpreter.ast.CompoundStatement;
import interpreter.ast.expression.*;
import interpreter.ast.expression.additive.AdditiveExpression;
import interpreter.ast.expression.additive.MinusExpression;
import interpreter.ast.expression.additive.PlusExpression;
import interpreter.ast.expression.constant.ConstantExpression;
import interpreter.ast.expression.constant.DoubleConst;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;
import interpreter.ast.expression.equality.EqualExpression;
import interpreter.ast.expression.equality.NotEqualExpression;
import interpreter.ast.expression.multiplicative.DivideExpression;
import interpreter.ast.expression.multiplicative.TimesExpression;
import interpreter.ast.expression.relational.GreaterEqualExpression;
import interpreter.ast.expression.relational.GreaterThanExpression;
import interpreter.ast.expression.relational.LessEqualExpression;
import interpreter.ast.expression.relational.LessThanExpression;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.globalscope.FunctionDeclaration;
import interpreter.ast.globalscope.GlobalVariableDeclaration;
import interpreter.ast.globalscope.SimpleInitializer;
import interpreter.ast.globalscope.struct.*;
import interpreter.ast.statement.*;
import interpreter.ast.statement.iteration.DoWhileStatement;
import interpreter.ast.statement.iteration.ForStatement;
import interpreter.ast.statement.iteration.IterationStatement;
import interpreter.ast.statement.iteration.WhileStatement;
import interpreter.visitor.struct.GlobalStructUnit;
import interpreter.visitor.struct.StructStatement;
import interpreter.visitor.struct.StructVisitorImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class EvalVisitor implements Visitor  {

    private StructVisitorImpl structVisitor = new StructVisitorImpl();

    @Override
    public Object visit(StructInitializer structInitializer) {
       return structVisitor.visit(structInitializer);
    }

    protected boolean brk = false;
    protected boolean cnt = false;

    public Object visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) {
        return abstractGlobalScopeUnit.accept(this);
    }

    public Object visit(FunctionDeclaration functionDeclaration) {

        Table.beginScope();
        functionDeclaration.getStatementList().accept(this);
        Table.endScope();
        return null;
    }



    public Object visit(GlobalVariableDeclaration globalVariableDeclaration) {
        if (Table.fp == -1)
            Table.beginScope();
        Object expression = globalVariableDeclaration.getValue().accept(this);
        Table.add(globalVariableDeclaration.getId(), expression);
        return null;
    }

    public Object visit(IntConst exp) {
        return exp.getConstInt();
    }

    public Object visit(StrConst exp) {
        exp.setValue(exp.getValue().replace("\"", ""));
        return exp.getValue();
    }

    public Object visit(DoubleConst exp) {
        return exp.getDoubleConst();
    }

    public Object visit(StatementList s) {

        Statement statementList = null;
        Statement statement = (Statement) s.getStatement().accept(this);
        brk = false;
        cnt = false;
        if (Objects.nonNull(s.getStatementList()))
            statementList = (Statement) s.getStatementList().accept(this);

        return new StatementList(statement, statementList);
    }

    public Object visit(Expression e) {
        return e.accept(this);
    }


    public Object visit(Print printStatement) {
        System.out.println(printStatement.getExpression().accept(this));
        return printStatement;
    }


    public Expression visit(LogicalOR e) {

        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        return new BoolExpression(
                ((BoolExpression) left).isBoolValue() || ((BoolExpression) right).isBoolValue());
    }


    public Expression visit(LogicalAND e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        return new BoolExpression(
                ((BoolExpression) left).isBoolValue() && ((BoolExpression) right).isBoolValue());
    }

    @Override
    public Object visit(EqualExpression e) {
        Object left = e.getLeft().accept(this);
        Object right = e.getRight().accept(this);

        return left.equals(right);

    }

    @Override
    public Object visit(NotEqualExpression expression) {

        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return (left != right);

    }

    public Expression visit(RelationalExpression e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);

        return new RelationalExpression(left, right, e.getOperatorType());
    }

    @Override
    public Object visit(LessThanExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return new BoolExpression(left.toString().compareTo(right.toString()) < 0).isBoolValue();

    }

    @Override
    public Object visit(LessEqualExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return new BoolExpression(left.toString().compareTo(right.toString()) <= 0).isBoolValue();

    }

    @Override
    public Object visit(GreaterThanExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return new BoolExpression(left.toString().compareTo(right.toString()) > 0).isBoolValue();

    }

    @Override
    public Object visit(GreaterEqualExpression expression) {

        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return new BoolExpression(left.toString().compareTo(right.toString()) >= 0).isBoolValue();

    }

    public Object visit(AdditiveExpression e) {
        Object left = e.getLeft().accept(this);
        Object right = e.getRight().accept(this);

        e.setLeftType(left.getClass().getSimpleName());
        e.setRightType(right.getClass().getSimpleName());

        return null;
    }

    @Override
    public Object visit(PlusExpression expression) {

        expression.superAccept(this);
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        if (expression.getLeftType().equals("String") || expression.getRightType().equals("String")) {
            return new StrConst(((String) left) + right).getValue();
        } else if (expression.getLeftType().equals("Integer") || expression.getRightType().equals(
                "Integer"))
            return new IntConst((Integer) left + (Integer) right).getConstInt();
        else
            return new DoubleConst((Double) left + (Double) right).getDoubleConst();

    }

    @Override
    public Object visit(MinusExpression expression) {

        expression.superAccept(this);
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        if (expression.getLeftType().equals("Integer") || expression.getRightType().equals("Integer"))
            return new IntConst((Integer) left - (Integer) right).getConstInt();
        else
            return new DoubleConst((Double) left - (Double) right).getDoubleConst();
    }

    @Override
    public Object visit(TimesExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        if (left instanceof Integer || right instanceof Integer)
            return new IntConst((Integer) left * (Integer) right).getConstInt();
        else {
            return new DoubleConst((Double) left * (Double) right).getDoubleConst();
        }
    }

    @Override
    public Object visit(DivideExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        if (left instanceof Integer || right instanceof Integer)
            return new IntConst((Integer) left / (Integer) right).getConstInt();
        else {
            return new DoubleConst((Double) left / (Double) right).getDoubleConst();
        }
    }

    public Expression visit(ExponentialExpression e) {
        Expression value = (Expression) e.getValue().accept(this);
        Expression power = (Expression) e.getPower().accept(this);
        return value;
    }

    public Object visit(UnaryExpression e) {
        return e.getExpression().accept(this);
    }


    public Expression visit(PrimaryExpression e) {
        return (Expression) e.getExp().accept(this);
    }


    public Object visit(ConstantExpression e) {
        return e.getConstantValue().accept(this);
    }

    public Expression visit(PrimaryExpressionPrime e) {
        Expression n1 = (Expression) e.getExp().accept(this);
        return n1;
    }


    public Object visit(ExpressionList e) {
        Object expression = e.getE1().accept(this);

        ExpressionList expressionList;
        if (e.getE2() != null)
            return e.getE2().accept(this);

        return expression;
    }


    public Expression visit(BoolExpression e) {
        return e;
    }


    public Object visit(PostfixExpression expression) {

        Object value = null;
        int fpTemp = Table.fp;
        String structInstanceId = ((IdExpression) expression.getPrimaryExpression()).getId();
        String variableId = expression.getChildId();

        Util.setScopeFor(structInstanceId, variableId);

        value = Table.getStructVariable(structInstanceId, variableId);
        Table.fp = fpTemp;
        return value;
    }



    public Object visit(SimpleInitializer simpleInitializer) {
        if (simpleInitializer.getExpression() != null)
            return simpleInitializer.getExpression().accept(this);
        else
            return simpleInitializer.getStructInitializer().getExpressions().accept(this);
    }

    public Object visit(VariableDeclarationStatement statement) {

        Table.add(statement.getId(), statement.getValueExp().accept(this));
        return statement;

    }

    @Override
    public Object visit(ContinueStatement statement) {
        cnt = true;
        return null;
    }

    @Override
    public Object visit(BreakStatement statement) {
        brk = true;
        return null;
    }

    @Override
    public Object visit(AssignmentStatement statement) {

        Object value = statement.getValueExp().accept(this);
        Table.add(statement.getId(), value);

        return null;

    }

    @Override
    public Object visit(ExpressionStatement statement) {
        if (statement.getExpression() != null) {
            statement.getExpression().accept(this);
        }

        return null;
    }

    @Override
    public Object visit(IfStatement statement) {

        Object boolExp = statement.getBoolExpression().accept(this);
        Table.beginScope();
        if ((boolean) boolExp) {
            statement.getTrueBlock().accept(this);
        } else if (statement.getElseBlock() != null) {
            statement.getElseBlock().accept(this);
        }
        Table.endScope();

        return null;
    }


    @Override
    public Object visit(ReturnStatement statement) {
        return null;
    }


    @Override
    public Object visit(CompoundStatement statement) {
        return null;
    }

    public Object visit(IterationStatement statement) {
        return null;
    }

    @Override
    public Object visit(WhileStatement statement) {
        return null;
    }

    @Override
    public Object visit(DoWhileStatement statement) {
        return null;
    }

    @Override
    public Object visit(ForStatement statement) {

        Table.beginScope();
        if (statement.getForIndex() != null)
            statement.getForIndex().accept(this);

        while ((boolean) statement.getBoolExpression().accept(this)) {
            statement.getIterationBody().accept(this);
            if (brk) {
                break;
            }
            if (statement.getForIncrement() != null)
                statement.getForIncrement().accept(this);
        }

        Table.endScope();
        return null;
    }

    @Override
    public Object visit(IdExpression idExpression) {

       Object value = null;
        int fpTemp = Table.fp;
        while (Objects.isNull(value)) {
            value = Table.get(idExpression.getId());
            Table.fp--;
            if (Table.fp == -1) {
                break;
            }
        }
        Table.fp = fpTemp;
        return value;
    }
}
