package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.ExpressionUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimaryExpressionPrime implements ExpressionUnit {

    private Expression exp;

    public PrimaryExpressionPrime(Expression exp) {
        this.exp = exp;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }


    @Override
    public Object accept(EvalVisitor evalVisitor) {
        return evalVisitor.visit(this);
    }
}
