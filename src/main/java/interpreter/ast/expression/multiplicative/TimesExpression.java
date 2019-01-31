package interpreter.ast.expression.multiplicative;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TimesExpression extends Expression {

    private Expression left;
    private Expression right;

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
