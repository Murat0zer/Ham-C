package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.ExpressionUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimaryExpression implements ExpressionUnit {

    private Expression exp;
    private String id;

    public PrimaryExpression(Expression exp, String id) {
        this.id = id;
        this.exp = exp;
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
