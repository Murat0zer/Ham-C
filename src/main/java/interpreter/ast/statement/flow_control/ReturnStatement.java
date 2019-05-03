package interpreter.ast.statement.flow_control;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.flow_control.FlowControlUnit;
import interpreter.visitor.flow_control.FlowControlVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReturnStatement implements FlowControlUnit {

    private Expression expression;

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(FlowControlVisitor evalVisitor) {
        return evalVisitor.visit(this);
    }
}
