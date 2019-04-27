package interpreter.ast.statement;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BreakStatement implements Statement {

    private Statement statement;

    public Object accept(AbstractVisitor v) {
        v.visit(this);
        return null;
    }
}
