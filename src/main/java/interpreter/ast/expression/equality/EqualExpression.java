package interpreter.ast.expression.equality;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EqualExpression extends Expression {

    private Expression left;
    private Expression right;


    @Override
    public Object accept(Visitor v) {
       return v.visit(this);
    }
}
