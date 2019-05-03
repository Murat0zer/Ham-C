package interpreter.ast;

import interpreter.ast.statement.Statement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.StatementUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompoundStatement implements StatementUnit {

    private Statement statement;
    private Statement compoundStatement;

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(EvalVisitor evalVisitor) {
        return evalVisitor.visit(this);
    }
}
