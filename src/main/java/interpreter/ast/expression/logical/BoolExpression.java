package interpreter.ast.expression.logical;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.logical.LogicalUnit;
import interpreter.visitor.logical.LogicalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoolExpression implements LogicalUnit {

    private boolean boolValue;

    public BoolExpression(boolean a) {
        boolValue = a;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(LogicalVisitor logicalVisitor) {
        return logicalVisitor.visit(this);
    }
}
