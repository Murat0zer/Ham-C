package interpreter.ast.statement;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.StatementUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VariableDeclarationStatement implements StatementUnit {

    private String type;
    private String id;
    private Expression valueExp;

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(EvalVisitor evalVisitor) {
        return evalVisitor.visit(this);
    }
}
