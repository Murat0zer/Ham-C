package interpreter.visitor.arithmetic;

import interpreter.ast.expression.ExponentialExpression;
import interpreter.ast.expression.Expression;
import interpreter.ast.expression.arithmetic.additive.AdditiveExpression;
import interpreter.ast.expression.arithmetic.additive.MinusExpression;
import interpreter.ast.expression.arithmetic.additive.PlusExpression;
import interpreter.ast.expression.arithmetic.multiplicative.DivideExpression;
import interpreter.ast.expression.arithmetic.multiplicative.TimesExpression;
import interpreter.ast.expression.constant.DoubleConst;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;
import interpreter.visitor.VisitorVisitor;

public class ArithmeticVisitorImpl extends VisitorVisitor implements ArithmeticVisitor {


    @Override
    public Object visit(ArithmeticUnit arithmeticUnit) {
        return arithmeticUnit.accept(this);
    }



    @Override
    public Object visit(PlusExpression expression) {

        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        expression.setLeftType(left.getClass().getSimpleName());
        expression.setRightType(right.getClass().getSimpleName());

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

    @Override
    public Expression visit(ExponentialExpression e) {
        Expression value = (Expression) e.getValue().accept(this);
        Expression power = (Expression) e.getPower().accept(this);
        return value;
    }
}
