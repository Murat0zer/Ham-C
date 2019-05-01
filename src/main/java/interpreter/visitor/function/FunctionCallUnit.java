package interpreter.visitor.function;

import interpreter.ast.expression.Expression;

public interface FunctionCallUnit extends Expression {
    Object accept(FunctionVisitor functionVisitor);
}
