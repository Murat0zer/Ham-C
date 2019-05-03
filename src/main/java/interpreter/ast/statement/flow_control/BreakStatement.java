package interpreter.ast.statement.flow_control;

import interpreter.ast.statement.Statement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.flow_control.FlowControlUnit;
import interpreter.visitor.flow_control.FlowControlVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BreakStatement implements FlowControlUnit {

    private Statement statement;

    public Object accept(AbstractVisitor v) {
        v.visit(this);
        return null;
    }

    @Override
    public Object accept(FlowControlVisitor flowControlVisitor) {
        return flowControlVisitor.visit(this);
    }
}
