package interpreter.visitor.flow_control;

import interpreter.ast.statement.flow_control.BreakStatement;
import interpreter.ast.statement.flow_control.ContinueStatement;
import interpreter.ast.statement.flow_control.IfStatement;
import interpreter.ast.statement.flow_control.ReturnStatement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.ExpressionUnit;
import interpreter.visitor.StatementUnit;
import interpreter.visitor.VisitorVisitor;

public interface FlowControlVisitor extends AbstractVisitor {

    @Override
    Object visit(FlowControlUnit flowControlUnit);

    @Override
    default Object visit(ExpressionUnit expressionUnit) {
        return expressionUnit.accept(new VisitorVisitor());
    }

    @Override
    default Object visit(StatementUnit statementUnit) {
        return statementUnit.accept(new VisitorVisitor());
    }

    Object visit(ContinueStatement statement);

    Object visit(BreakStatement statement);

    Object visit(IfStatement statement);

    Object visit(ReturnStatement statement);


}
