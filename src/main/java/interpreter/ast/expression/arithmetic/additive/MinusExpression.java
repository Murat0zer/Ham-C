package interpreter.ast.expression.arithmetic.additive;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.arithmetic.ArithmeticUnit;
import interpreter.visitor.arithmetic.ArithmeticVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinusExpression extends AdditiveExpression implements ArithmeticUnit {

    public MinusExpression(Expression left, Expression right) {
        super(left, right);
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
