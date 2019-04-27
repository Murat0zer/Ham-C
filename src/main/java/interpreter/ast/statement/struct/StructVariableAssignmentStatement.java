package interpreter.ast.statement.struct;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import interpreter.visitor.struct.StructStatement;
import interpreter.visitor.struct.StructVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StructVariableAssignmentStatement implements StructStatement {

    private Expression postfixExpression;
    private Expression value;

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(StructVisitor structVisitor) {
        return structVisitor.visit(this);
    }
}
