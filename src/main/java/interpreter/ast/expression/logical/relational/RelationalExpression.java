package interpreter.ast.expression.logical.relational;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.logical.LogicalUnit;
import interpreter.visitor.logical.LogicalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelationalExpression implements LogicalUnit {

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
    }

    @Override
    public Object accept(LogicalVisitor logicalVisitor) {
        return logicalVisitor.visit(this);
    }
}
