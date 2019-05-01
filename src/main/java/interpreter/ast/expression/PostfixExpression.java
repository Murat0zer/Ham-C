package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.ExpressionUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostfixExpression implements ExpressionUnit {
    private Expression primaryExpression;
    private Expression expression;
    private String childId;

    public PostfixExpression(Expression primaryExpression, Expression expression, String childId) {
        this.primaryExpression = primaryExpression;
        this.expression = expression;
        this.childId = childId;
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
