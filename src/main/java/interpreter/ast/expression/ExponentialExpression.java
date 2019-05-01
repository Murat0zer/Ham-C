package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.arithmetic.ArithmeticUnit;
import interpreter.visitor.arithmetic.ArithmeticVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExponentialExpression implements ArithmeticUnit {
    private Expression value;
    private Expression power;

    public ExponentialExpression(Expression value, Expression power) {
        this.value = value;
        this.power = power;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(ArithmeticVisitor arithmeticVisitor) {
        return arithmeticVisitor.visit(this);
    }
}
