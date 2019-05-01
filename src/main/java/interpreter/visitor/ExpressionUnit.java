package interpreter.visitor;

import interpreter.ast.expression.Expression;

public interface ExpressionUnit extends Expression {
    Object accept(EvalVisitor evalVisitor);
}
