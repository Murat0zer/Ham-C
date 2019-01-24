package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExponentialExpression extends Expression {
    private Expression value;
    private Expression power;

    public ExponentialExpression(Expression value, Expression power) {
        this.value = value;
        this.power = power;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
