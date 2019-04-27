package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelationalExpression implements Expression {

    private Expression left;
    private Expression right;
    private String operatorType;

    public RelationalExpression(Expression left, Expression right, String operatorType) {
        this.left = left;
        this.right = right;
        this.operatorType = operatorType;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
