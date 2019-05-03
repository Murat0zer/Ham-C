package interpreter.visitor.logical;

import interpreter.ast.expression.Expression;
import interpreter.ast.expression.logical.BoolExpression;
import interpreter.ast.expression.logical.LogicalAND;
import interpreter.ast.expression.logical.LogicalOR;
import interpreter.ast.expression.logical.equality.EqualExpression;
import interpreter.ast.expression.logical.equality.NotEqualExpression;
import interpreter.ast.expression.logical.relational.*;
import interpreter.visitor.VisitorVisitor;

import java.math.BigInteger;

public class LogicalVisitorImpl extends VisitorVisitor implements LogicalVisitor {


    @Override
    public Object visit(LogicalUnit logicalUnit) {
        return logicalUnit.accept(this);
    }

    @Override
    public Expression visit(LogicalAND e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        return new BoolExpression(
                ((BoolExpression) left).isBoolValue() && ((BoolExpression) right).isBoolValue());
    }

    @Override
    public Expression visit(LogicalOR e) {

        Boolean left = (Boolean) e.getLeft().accept(this);
        Boolean right = (Boolean) e.getRight().accept(this);
        return new BoolExpression(( left) || (right));
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

    @Override
    public Expression visit(RelationalExpression e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);

        return new RelationalExpression(left, right, e.getOperatorType());
    }

    @Override
    public Object visit(LessThanExpression expression) {

        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        BigInteger bigIntegerL = new BigInteger(String.valueOf(left));
        BigInteger bigIntegerR = new BigInteger(String.valueOf(right));
        boolean b = bigIntegerL.compareTo(bigIntegerR) < 0;
        return new BoolExpression(b).isBoolValue();

    }

    @Override
    public Object visit(LessEqualExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        BigInteger bigIntegerL = new BigInteger(String.valueOf(left));
        BigInteger bigIntegerR = new BigInteger(String.valueOf(right));
        boolean b = bigIntegerL.compareTo(bigIntegerR) <= 0;
        return new BoolExpression(b).isBoolValue();

    }

    @Override
    public Object visit(GreaterThanExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        BigInteger bigIntegerL = new BigInteger(String.valueOf(left));
        BigInteger bigIntegerR = new BigInteger(String.valueOf(right));
        boolean b = bigIntegerL.compareTo(bigIntegerR) > 0;
        return new BoolExpression(b).isBoolValue();

    }

    @Override
    public Object visit(GreaterEqualExpression expression) {

        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        BigInteger bigIntegerL = new BigInteger(String.valueOf(left));
        BigInteger bigIntegerR = new BigInteger(String.valueOf(right));
        boolean b = bigIntegerL.compareTo(bigIntegerR) >= 0;
        return new BoolExpression(b).isBoolValue();

    }

    @Override
    public Expression visit(BoolExpression e) {
        return e;
    }


}
