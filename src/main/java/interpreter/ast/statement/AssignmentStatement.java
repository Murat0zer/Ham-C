package interpreter.ast.statement;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.StatementUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentStatement implements StatementUnit {

    private Expression valueExp;
    private String id;

    @Override
    public Object accept(AbstractVisitor v) {
         return v.visit(this);
    }

    @Override
    public Object accept(EvalVisitor evalVisitor) {
        return evalVisitor.visit(this);
    }
}
