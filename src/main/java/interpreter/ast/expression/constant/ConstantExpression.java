package interpreter.ast.expression.constant;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantExpression implements Expression {

    private Expression constantValue;

    public ConstantExpression(Expression constantValue) {
        this.constantValue = constantValue;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
