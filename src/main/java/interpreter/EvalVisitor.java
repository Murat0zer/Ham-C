package interpreter;

import interpreter.ast.CompoundStatement;
import interpreter.ast.LabelBlock;
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
import interpreter.ast.globalscope.struct.StructDeclaration;
import interpreter.ast.globalscope.struct.StructInitializer;
import interpreter.ast.globalscope.struct.StructMemberDeclaration;
import interpreter.ast.statement.*;
import interpreter.ast.statement.iteration.DoWhileStatement;
import interpreter.ast.statement.iteration.ForStatement;
import interpreter.ast.statement.iteration.IterationStatement;
import interpreter.ast.statement.iteration.WhileStatement;

import java.util.*;

class EvalVisitor implements Visitor {

    boolean brk = false;
    boolean cnt = false;
    Table table = new Table(1000);

    public void visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) {
        abstractGlobalScopeUnit.accept(this);

    }

    public void visit(FunctionDeclaration functionDeclaration) {

        table.beginScope();
        functionDeclaration.getStatementList().accept(this);
        table.endScope();

    }

    public void visit(StructDeclaration structDeclaration) {
    }

    public void visit(GlobalVariableDeclaration globalVariableDeclaration) {
        if (table.fp == -1)
            table.beginScope();
        Object expression = globalVariableDeclaration.getValue().accept(this);
        table.add(globalVariableDeclaration.getId(), expression);


    }

    public Object visit(IntConst exp) {
        return exp.getConstInt();
    }

    public Object visit(StrConst exp) {
        return exp.getValue();
    }

    public Object visit(DoubleConst exp) {
        return exp.getDoubleConst();
    }

    public Object visit(StatementList s) {

        Statement statementList = null;
        Statement statement = (Statement) s.getStatement().accept(this);
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
        return new BoolExpression(((BoolExpression) left).isBoolValue() || ((BoolExpression) right).isBoolValue());
    }


    public Expression visit(LogicalAND e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        return new BoolExpression(((BoolExpression) left).isBoolValue() && ((BoolExpression) right).isBoolValue());
    }

    @Override
    public Object visit(EqualExpression e) {
        Object left =  e.getLeft().accept(this);
        Object right =  e.getRight().accept(this);

        return left.equals(right);

    }

    @Override
    public Object visit(NotEqualExpression expression) {

        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return ( left != right);

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
            String l = ((String) left).replace("\"", "");
            String r = ((String) right).replace("\"", "");
            return new StrConst(l + r).getValue();
        }
        else if (expression.getLeftType().equals("Integer") || expression.getRightType().equals("Integer"))
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
        Object n1 = e.getExpression().accept(this);
        return n1;
    }


    public Expression visit(PrimaryExpression e) {
        Expression n1 = (Expression) e.getExp().accept(this);
        return n1;
    }


    public Object visit(ConstantExpression e) {
        Object n1 = e.getConstantValue().accept(this);
        return n1;
    }

    public Expression visit(PrimaryExpressionPrime e) {
        Expression n1 = (Expression) e.getExp().accept(this);
        return n1;
    }


    public Expression visit(ExpressionList e) {
        return null;
    }


    public Expression visit(BoolExpression e) {
        return e;
    }


    public Object visit(PostfixExpression e) {
        return null;
    }


    public void visit(StructMemberDeclaration structMemberDeclaration) {

    }


    public Object visit(SimpleInitializer simpleInitializer) {
        return simpleInitializer.getExpression().accept(this);
    }


    public void visit(StructInitializer structInitializer) {

    }


    public Object visit(VariableDeclarationStatement statement) {

        this.table.add(statement.getId(), statement.getValueExp().accept(this));
        return statement;

    }

    @Override
    public Object visit(ContinueStatement statement) {
        return null;
    }

    @Override
    public Object visit(BreakStatement statement) {
        return null;
    }

    @Override
    public Object visit(ExpressionOrAssignmentStatement statement) {
        return null;
    }

    @Override
    public Object visit(IfStatement statement) {
        return null;
    }

    @Override
    public Object visit(LabelStatement statement) {
        return null;
    }

    @Override
    public Object visit(ReturnStatement statement) {
        return null;
    }

    @Override
    public Object visit(SwitchBlock statement) {
        return null;
    }

    @Override
    public Object visit(SwitchStatement statement) {
        return null;
    }

    @Override
    public Object visit(CompoundStatement statement) {
        return null;
    }

    @Override
    public Object visit(LabelBlock statement) {
        return null;
    }

    @Override
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
        return null;
    }

    @Override
    public Object visit(IdExpression idExpression) {
        Object value = null;
        int fpTemp = table.fp;
        while (Objects.isNull(value)) {
            value = table.get(idExpression.getId());
            table.fp--;
            if (table.fp == -1) {
                break;
            }
        }
        table.fp = fpTemp;
        return value;
    }

}