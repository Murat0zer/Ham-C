package interpreter.ast.statement.flow_control;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.flow_control.FlowControlUnit;
import interpreter.visitor.flow_control.FlowControlVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContinueStatement implements FlowControlUnit {

    public Object accept(AbstractVisitor v) {
        return v.visit(this);

    }

    @Override
    public Object accept(FlowControlVisitor flowControlVisitor) {
        return flowControlVisitor.visit(this);
    }
}
