package interpreter.ast.expression.multiplicative;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DivideExpression implements Expression {

    private Expression left;
    private Expression right;


    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
