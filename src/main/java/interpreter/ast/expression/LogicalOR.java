package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogicalOR extends Expression {
    private Expression left;
    private Expression right;

    public LogicalOR(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}
