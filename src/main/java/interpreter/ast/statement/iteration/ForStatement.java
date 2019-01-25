package interpreter.ast.statement.iteration;

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
public class ForStatement extends IterationStatement {

    private Expression forIndex;
    private Expression forIncrement;

    public ForStatement(Expression boolExpression, Statement iterationBody, Expression forIndex, Expression forIncrement) {
        super(boolExpression, iterationBody);
        this.forIndex = forIndex;
        this.forIncrement = forIncrement;
    }
}
