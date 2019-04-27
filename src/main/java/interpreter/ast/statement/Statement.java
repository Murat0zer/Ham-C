package interpreter.ast.statement;

import interpreter.visitor.AbstractVisitor;

public interface Statement {
    Object accept(AbstractVisitor v);
}
