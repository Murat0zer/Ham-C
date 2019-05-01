package interpreter.ast.expression.logical.relational;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.logical.LogicalUnit;
import interpreter.visitor.logical.LogicalVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LessThanExpression implements LogicalUnit {

    private Expression left;
    private Expression right;

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }


    @Override
    public Object accept(LogicalVisitor logicalVisitor) {
        return logicalVisitor.visit(this);
    }
}
