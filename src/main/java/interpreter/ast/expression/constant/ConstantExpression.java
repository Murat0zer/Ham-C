package interpreter.ast.expression.constant;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.constant.ConstantUnit;
import interpreter.visitor.constant.ConstantVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConstantExpression implements ConstantUnit {

    private Expression constantValue;

    public ConstantExpression(Expression constantValue) {
        this.constantValue = constantValue;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(ConstantVisitor constantVisitor) {
        return constantVisitor.visit(this);
    }
}
