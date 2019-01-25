package interpreter.ast.statement.iteration;

import interpreter.Visitor;
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
public class IterationStatement extends Statement {

    private Expression boolExpression;
    private Statement iterationBody;

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
