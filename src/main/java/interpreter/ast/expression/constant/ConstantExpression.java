package interpreter.ast.expression.constant;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantExpression extends Expression {

    private Expression constantValue;

    public ConstantExpression(Expression constantValue) {
        this.constantValue = constantValue;
    }

    public Object accept(Visitor v) {

        return v.visit(this);
    }

}
