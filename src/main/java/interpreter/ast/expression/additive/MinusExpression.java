package interpreter.ast.expression.additive;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinusExpression extends  AdditiveExpression {

    public MinusExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }

    public Object superAccept(Visitor v) {
        return super.accept(v);
    }
}