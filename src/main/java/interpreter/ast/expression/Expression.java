package interpreter.ast.expression;

import interpreter.Visitor;

public abstract class Expression {
    public abstract Object accept(Visitor v);
}
