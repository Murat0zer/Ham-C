package interpreter.visitor.arithmetic;

import interpreter.ast.expression.Expression;

public interface ArithmeticUnit extends Expression {
    Object accept(ArithmeticVisitor arithmeticVisitor);
}
