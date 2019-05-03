package interpreter.ast.expression.logical.equality;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.logical.LogicalUnit;
import interpreter.visitor.logical.LogicalVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EqualExpression implements LogicalUnit {

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
