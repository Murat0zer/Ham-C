package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UnaryExpression implements Expression {

    private Expression expression;
    private String unaryOp = null;

    public UnaryExpression(Expression expression, String unaryOp) {
        this.expression = expression;
        this.unaryOp = unaryOp;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
