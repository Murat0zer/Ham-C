package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogicalAND extends Expression {
    private Expression left;
    private Expression right;

    public LogicalAND(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}
