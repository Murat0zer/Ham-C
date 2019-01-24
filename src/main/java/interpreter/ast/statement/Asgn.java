package interpreter.ast.statement;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;

public class Asgn extends Statement {
    String id;
    Expression e;

    public Asgn(String a, Expression b) {
        id = a;
        e = b;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
