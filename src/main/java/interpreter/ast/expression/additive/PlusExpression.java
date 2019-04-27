package interpreter.ast.expression.additive;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlusExpression extends AdditiveExpression {

    public PlusExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    public Object superAccept(AbstractVisitor v) {
        return super.accept(v);
    }
}
