package interpreter.ast.statement;

import interpreter.Visitor;

public abstract class Statement {
    public abstract Object accept(Visitor v);
}
