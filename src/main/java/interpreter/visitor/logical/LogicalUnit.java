package interpreter.visitor.logical;

import interpreter.ast.expression.Expression;

public interface LogicalUnit extends Expression {

    Object accept(LogicalVisitor logicalVisitor);
}
