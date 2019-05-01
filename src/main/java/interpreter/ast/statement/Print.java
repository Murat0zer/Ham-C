package interpreter.ast.statement;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.StatementUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Print implements StatementUnit {

    private Expression expression;

    public Print(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(EvalVisitor evalVisitor) {
        return evalVisitor.visit(this);
    }
}
