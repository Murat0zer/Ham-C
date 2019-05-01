package interpreter.visitor.iteration;

import interpreter.Table;
import interpreter.ast.statement.iteration.DoWhileStatement;
import interpreter.ast.statement.iteration.ForStatement;
import interpreter.ast.statement.iteration.IterationStatement;
import interpreter.ast.statement.iteration.WhileStatement;
import interpreter.visitor.VisitorVisitor;
import javafx.scene.control.Tab;

public class IterationVisitorImpl extends VisitorVisitor implements IterationVisitor {


    @Override
    public Object visit(IterationUnit iterationUnit) {
        return iterationUnit.accept(this);
    }

    @Override
    public Object visit(WhileStatement statement) {
        return null;
    }

    @Override
    public Object visit(DoWhileStatement statement) {
        return null;
    }

    @Override
    public Object visit(ForStatement statement) {

        Table.beginScope();
        Table.add("break", false);
        Table.add("continue", false);
        if (statement.getForIndex() != null)
            statement.getForIndex().accept(this);

        while ((boolean) statement.getBoolExpression().accept(this)) {
            statement.getIterationBody().accept(this);
            if ((boolean) Table.get("break")) {
                break;
            }
            if (statement.getForIncrement() != null)
                statement.getForIncrement().accept(this);
        }

        Table.endScope();
        return null;
    }

    public Object visit(IterationStatement statement) {
        return null;
    }

}
