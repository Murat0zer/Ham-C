package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditiveExpression extends Expression {

    private Expression left;
    private Expression right;
    private String operatorType;

    public AdditiveExpression(Expression left, Expression right, String operatorType) {
        this.left = left;
        this.right = right;
        this.operatorType = operatorType;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}
