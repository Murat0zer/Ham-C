package interpreter.ast.statement.iteration;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IterationStatement implements Statement {

    private Expression boolExpression;
    private Statement iterationBody;

    public Object accept(AbstractVisitor v) {
         return v.visit(this);
    }
}
