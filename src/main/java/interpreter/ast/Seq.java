package interpreter.ast;

import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.ExpressionUnit;

public class Seq implements ExpressionUnit {
    Statement s;
    Expression e;

    public Seq(Statement a, Expression b) {
        s = a;
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
