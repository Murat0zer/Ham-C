package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostfixExpression implements Expression {
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
    }}
