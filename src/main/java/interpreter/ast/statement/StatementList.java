package interpreter.ast.statement;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatementList extends Statement {

    private Statement s1;
    private Statement s2;

    public StatementList(Statement a, Statement b) {
        s1 = a;
        s2 = b;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
