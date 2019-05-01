package interpreter.ast.expression.arithmetic.additive;

import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AdditiveExpression {

    private Expression left;
    private Expression right;
    private String leftType;
    private String rightType;

    public AdditiveExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

}
