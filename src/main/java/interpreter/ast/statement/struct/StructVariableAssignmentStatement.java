package interpreter.ast.statement.struct;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StructVariableAssignmentStatement extends Statement {

    private Expression postfixExpression;
    private Expression value;

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
