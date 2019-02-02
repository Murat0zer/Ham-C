package interpreter.ast.statement;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpressionStatement extends Statement {

    private Expression expression;

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
