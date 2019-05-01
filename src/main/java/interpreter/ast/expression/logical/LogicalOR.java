package interpreter.ast.expression.logical;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.logical.LogicalUnit;
import interpreter.visitor.logical.LogicalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogicalOR implements LogicalUnit {
    private Expression left;
    private Expression right;

    public LogicalOR(Expression left, Expression right) {
        this.left = left;
        this.right = right;
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
