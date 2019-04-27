package interpreter.ast.expression.additive;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditiveExpression implements Expression {

    private Expression left;
    private Expression right;
    private String leftType;
    private String rightType;

    public AdditiveExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

}
