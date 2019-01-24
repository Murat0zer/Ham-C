package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpressionList extends Expression {

    private Expression e1;
    private Expression e2;

    public ExpressionList(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}
