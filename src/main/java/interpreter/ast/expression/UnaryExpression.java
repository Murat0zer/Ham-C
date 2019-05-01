package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.ExpressionUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnaryExpression implements ExpressionUnit {

    private Expression expression;
    private String unaryOp = null;

    public UnaryExpression(Expression expression, String unaryOp) {
        this.expression = expression;
        this.unaryOp = unaryOp;
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
