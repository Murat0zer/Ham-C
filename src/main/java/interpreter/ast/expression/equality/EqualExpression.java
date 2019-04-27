package interpreter.ast.expression.equality;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EqualExpression implements Expression {

    private Expression left;
    private Expression right;


    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
