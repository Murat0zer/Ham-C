package interpreter.ast.expression.relational;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessEqualExpression extends Expression {

    private Expression left;
    private Expression right;

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
