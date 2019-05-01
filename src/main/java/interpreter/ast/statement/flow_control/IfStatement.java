package interpreter.ast.statement.flow_control;

import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
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
public class IfStatement implements FlowControlUnit {

    private Expression boolExpression;
    private Statement trueBlock;
    private Statement elseBlock;

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(FlowControlVisitor flowControlVisitor) {
        return flowControlVisitor.visit(this);
    }
}


