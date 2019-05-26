package interpreter.visitor;

import interpreter.MyInterpreter;
import interpreter.Table;
import interpreter.Util;
import interpreter.ast.CompoundStatement;
import interpreter.ast.expression.*;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.globalscope.GlobalVariableDeclaration;
import interpreter.ast.globalscope.SimpleInitializer;
import interpreter.ast.statement.*;
import interpreter.ast.statement.flow_control.ReturnStatement;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class EvalVisitor extends VisitorVisitor implements Visitor  {

    @Override
    public Object visit(GlobalUnit globalUnit) {
        return globalUnit.accept(this);
    }

    @Override
    public Object visit(ExpressionUnit expressionUnit) {
        return expressionUnit.accept(this);
    }

    @Override
    public Object visit(StatementUnit statementUnit) {
        return statementUnit.accept(this);
    }

    public Object visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) {
        return abstractGlobalScopeUnit.accept(this);
    }

    public Object visit(GlobalVariableDeclaration globalVariableDeclaration) {
        if (Table.fp == -1)
            Table.beginScope();
        Object expression = globalVariableDeclaration.getValue().accept(this);
        Table.add(globalVariableDeclaration.getId(), expression);
        return null;
    }

    public Object visit(StatementList s) {

        StatementList newStatementList = new StatementList();
        if (s.getStatement() instanceof ReturnStatement){
            newStatementList.setStatement(s.getStatement());
            return ((ReturnStatement) newStatementList.getStatement()).getExpression().accept(this);
        }


        Object statementList = new Object();
        Object val = s.getStatement().accept(MyInterpreter.visitorSelector);

        if((boolean) Table.get("return")){
            return val;
        }

        Table.add("break", false);
        Table.add("continue", false);

        if(Objects.nonNull(s.getStatementList())) {
            statementList = s.getStatementList();

            if (statementList instanceof ReturnStatement)
                return ((ReturnStatement) statementList).accept(MyInterpreter.visitorSelector);
            if (statementList instanceof StatementList) {
                newStatementList.setStatement(((StatementList) statementList).getStatement());
                newStatementList.setStatementList(((StatementList) statementList).getStatementList());
            } else if (statementList != null) {
                newStatementList.setStatement((Statement) statementList);

            }

        }
        else
            return val;
         return newStatementList.accept(MyInterpreter.visitorSelector);
    }

    public Object visit(Expression e) {
        return e.accept(this);
    }


    public Object visit(Print printStatement) {
        System.out.println(printStatement.getExpression().accept(this));
        return printStatement;
    }


    public Object visit(UnaryExpression e) {
        return e.getExpression().accept(this);
    }


    public Expression visit(PrimaryExpression e) {
        return (Expression) e.getExp().accept(this);
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
    public Object visit(CompoundStatement statement) {
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
