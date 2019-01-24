package interpreter.ast.expression;

import interpreter.Visitor;

public class Call extends Expression {
    String id;
    Expression e;

    public Call(String a, Expression b) {
        id = a;
        e = b;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
