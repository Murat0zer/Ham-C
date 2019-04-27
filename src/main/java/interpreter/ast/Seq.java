package interpreter.ast;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;

public class Seq implements Expression {
    Statement s;
    Expression e;

    public Seq(Statement a, Expression b) {
        s = a;
        e = b;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
