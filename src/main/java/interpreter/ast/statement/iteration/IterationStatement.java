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
public abstract class IterationStatement {

    private Expression boolExpression;
    private Statement iterationBody;

}
