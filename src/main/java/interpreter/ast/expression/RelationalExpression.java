package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelationalExpression extends Expression {

    private Expression left;
    private Expression right;
    private String operatorType;

    public RelationalExpression(Expression left, Expression right, String operatorType) {
        this.left = left;
        this.right = right;
        this.operatorType = operatorType;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
