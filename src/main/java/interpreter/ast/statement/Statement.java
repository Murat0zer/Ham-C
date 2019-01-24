package interpreter.ast.statement;

import interpreter.Visitor;

public abstract class Statement {
    public abstract void accept(Visitor v);
}
