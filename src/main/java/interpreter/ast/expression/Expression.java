package interpreter.ast.expression;


import interpreter.visitor.AbstractVisitor;

public interface Expression {
    Object accept(AbstractVisitor v);
}
