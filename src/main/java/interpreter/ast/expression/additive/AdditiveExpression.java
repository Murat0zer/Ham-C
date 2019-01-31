package interpreter.ast.expression.additive;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditiveExpression extends Expression {

    private Expression left;
    private Expression right;
    private String leftType;
    private String rightType;

    public AdditiveExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}
