package interpreter.visitor.arithmetic;

import interpreter.ast.expression.ExponentialExpression;
import interpreter.ast.expression.arithmetic.additive.AdditiveExpression;
import interpreter.ast.expression.arithmetic.additive.MinusExpression;
import interpreter.ast.expression.arithmetic.additive.PlusExpression;
import interpreter.ast.expression.arithmetic.multiplicative.DivideExpression;
import interpreter.ast.expression.arithmetic.multiplicative.TimesExpression;
import interpreter.visitor.AbstractVisitor;

public interface ArithmeticVisitor extends AbstractVisitor {

    @Override
    Object visit(ArithmeticUnit arithmeticUnit);

//    Object visit(AdditiveExpression e);

    Object visit(PlusExpression expression);

    Object visit(MinusExpression expression);

    Object visit(TimesExpression expression);

    Object visit(DivideExpression expression);

    Object visit(ExponentialExpression e);

}
