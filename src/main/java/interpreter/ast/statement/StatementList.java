package interpreter.ast.statement;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatementList implements Statement {

    private Statement statement;
    private Statement statementList;

    public Object accept(AbstractVisitor v) {
        return v.visit( this);
    }
}
