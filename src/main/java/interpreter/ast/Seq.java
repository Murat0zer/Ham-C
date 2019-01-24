package interpreter.ast;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;

public class Seq extends Expression {
    Statement s;
    Expression e;

    public Seq(Statement a, Expression b) {
        s = a;
        e = b;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
