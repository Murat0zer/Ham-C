package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpressionList implements Expression {

    private Expression e1;
    private Expression e2;

    public ExpressionList(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
