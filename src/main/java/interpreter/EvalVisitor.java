package interpreter;

import interpreter.ast.expression.*;
import interpreter.ast.expression.constant.ConstantExpression;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;
import interpreter.ast.globalscope.*;
import interpreter.ast.globalscope.struct.StructDeclaration;
import interpreter.ast.globalscope.struct.StructInitializer;
import interpreter.ast.globalscope.struct.StructMemberDeclaration;
import interpreter.ast.statement.Print;
import interpreter.ast.statement.Statement;
import interpreter.ast.statement.StatementList;

class EvalVisitor implements Visitor {

    boolean brk = false;
    boolean cnt = false;
    Table table = new Table(1000);

    public void visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) {
        abstractGlobalScopeUnit.accept(this);
    }

    public void visit(FunctionDeclaration functionDeclaration) {
        functionDeclaration.getStatementList().accept(this);

    }

    public void visit(StructDeclaration structDeclaration) {
    }

    public void visit(GlobalVariableDeclaration globalVariableDeclaration) {
    }

    public Object visit(IntConst exp) {
        return exp.getConstInt();
    }

    public Object visit(StrConst exp) {
        return exp.getValue();
    }

    public void visit(StatementList s) {
        s.getS1().accept(this);
        if (!(brk || cnt))
            s.getS2().accept(this);
    }

    public Object visit(Expression e) {
        return e.accept(this);
    }


    public void visit(Statement s) {
        s.accept(this);
    }


    public void visit(Print printStatement) {
        System.out.println(printStatement.getExpression().accept(this));
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


    public Expression visit(EqualityExpression e) {

        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        BoolExpression result = new BoolExpression(false);

        if ("==".equals(e.getOperatorType())) {
            result.setBoolValue(((BoolExpression) left).isBoolValue() == ((BoolExpression) right).isBoolValue());
        } else if ("!=".equals(e.getOperatorType())) {
            result.setBoolValue(((BoolExpression) left).isBoolValue() != ((BoolExpression) right).isBoolValue());
        }

        return result;
    }


    public Expression visit(RelationalExpression e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        return left;
    }


    public Expression visit(AdditiveExpression e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        return left;
    }

    public Expression visit(MultiplicativeExpression e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        return left;
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

    
    public void visit(SimpleInitializer simpleInitializer) {

    }

    
    public void visit(StructInitializer structInitializer) {

    }


}