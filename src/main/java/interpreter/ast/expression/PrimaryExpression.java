package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrimaryExpression extends Expression {

    private Expression exp;
    private String id;

    public PrimaryExpression(Expression exp, String id) {
        this.id = id;
        this.exp = exp;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
