package interpreter.visitor.flow_control;

import interpreter.Table;
import interpreter.ast.statement.flow_control.BreakStatement;
import interpreter.ast.statement.flow_control.ContinueStatement;
import interpreter.ast.statement.flow_control.IfStatement;
import interpreter.ast.statement.flow_control.ReturnStatement;

public class FlowControlVisitorImpl implements FlowControlVisitor {


    @Override
    public Object visit(FlowControlUnit flowControlUnit) {
        return flowControlUnit.accept(this);
    }

    @Override
    public Object visit(IfStatement statement) {

        Object boolExp = statement.getBoolExpression().accept(this);
        Table.beginScope();
        if ((boolean) boolExp) {
            statement.getTrueBlock().accept(this);
        } else if (statement.getElseBlock() != null) {
            statement.getElseBlock().accept(this);
        }
        Table.endScope();

        return null;
    }

    @Override
    public Object visit(ContinueStatement statement) {
        Table.add("continue", true);
        return null;
    }

    @Override
    public Object visit(BreakStatement statement) {
        Table.add("break", true);
        return null;
    }

    @Override
    public Object visit(ReturnStatement statement) {
        return statement.getExpression().accept(this);
    }
}
