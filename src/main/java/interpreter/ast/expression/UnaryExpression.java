package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnaryExpression extends Expression {

    private Expression expression;
    private String unaryOp = null;

    public UnaryExpression(Expression expression, String unaryOp) {
        this.expression = expression;
        this.unaryOp = unaryOp;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}
