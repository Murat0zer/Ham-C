package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExponentialExpression implements Expression {
    private Expression value;
    private Expression power;

    public ExponentialExpression(Expression value, Expression power) {
        this.value = value;
        this.power = power;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
