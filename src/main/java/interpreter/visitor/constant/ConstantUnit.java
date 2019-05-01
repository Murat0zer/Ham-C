package interpreter.visitor.constant;

import interpreter.ast.expression.Expression;

public interface ConstantUnit extends Expression {
    Object accept(ConstantVisitor constantVisitor);
}
