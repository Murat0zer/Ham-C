package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.ExpressionUnit;

public class Call implements ExpressionUnit {
    String id;
    Expression e;

    public Call(String a, Expression b) {
        id = a;
        e = b;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(EvalVisitor evalVisitor) {
        return evalVisitor.visit(this);
    }
}
