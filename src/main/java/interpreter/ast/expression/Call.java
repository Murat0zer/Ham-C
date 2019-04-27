package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;

public class Call implements Expression {
    String id;
    Expression e;

    public Call(String a, Expression b) {
        id = a;
        e = b;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
