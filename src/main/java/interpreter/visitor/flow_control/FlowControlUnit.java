package interpreter.visitor.flow_control;

import interpreter.ast.statement.Statement;

public interface FlowControlUnit extends Statement {


    Object accept(FlowControlVisitor flowControlVisitor);
}
