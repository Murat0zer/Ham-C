package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimaryExpressionPrime extends Expression {

    private Expression exp;

    public PrimaryExpressionPrime(Expression exp) {
        this.exp = exp;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}
