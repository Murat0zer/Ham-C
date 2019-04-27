package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogicalAND implements Expression {
    private Expression left;
    private Expression right;

    public LogicalAND(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
