package interpreter.ast.statement;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentStatement implements Statement {

    private Expression valueExp;
    private String id;

    @Override
    public Object accept(AbstractVisitor v) {
         return v.visit(this);
    }
}
