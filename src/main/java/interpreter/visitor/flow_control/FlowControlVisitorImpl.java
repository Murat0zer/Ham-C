package interpreter.visitor.flow_control;

import interpreter.MyInterpreter;
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

        Boolean result = (Boolean) statement.getBoolExpression().accept(MyInterpreter.visitorSelector);
        String calleeId = Table.get("callee_id").toString();
        String callerId = Table.get("caller_id").toString();
        Table.beginScope();
        Table.add("callee_id", calleeId);
        Table.add("caller_id", callerId);
        Table.add("return", false);
        Table.add("break", false);
        Table.add("continue", false);

        Object val = null;
        if (result) {
          val =  statement.getTrueBlock().accept(MyInterpreter.visitorSelector);
        } else if (statement.getElseBlock() != null) {
           val = statement.getElseBlock().accept(MyInterpreter.visitorSelector);
        }
        Table.endScope();

        return val;
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

    /**
     *  Return true ifadesi fonksiyonun scope u da dahil tum scopelardaki return degerlerini true yapmalidir.
     *  Boylece fonksiyonun diger statementleri isleme alinmaz.
     * @param statement
     * @return
     */
    @Override
    public Object visit(ReturnStatement statement) {

        String id = String.valueOf(Table.get("callee_id"));

        int tempFp = Table.fp;
        while (id.equals(Table.get("callee_id").toString())) {
            Table.add("return", true);
            Table.fp--;
        }
        Table.fp = tempFp;
        return statement.getExpression().accept(MyInterpreter.visitorSelector);
    }
}
