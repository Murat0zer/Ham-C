package interpreter.ast.statement;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Print implements Statement {

    private Expression expression;

    public Print(Expression expression) {
        this.expression = expression;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
