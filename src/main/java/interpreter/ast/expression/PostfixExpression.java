package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostfixExpression extends Expression {
    private Expression primaryExpression;
    private Expression expression;
    private String childId;

    public PostfixExpression(Expression primaryExpression, Expression expression, String childId) {
        this.primaryExpression = primaryExpression;
        this.expression = expression;
        this.childId = childId;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}
