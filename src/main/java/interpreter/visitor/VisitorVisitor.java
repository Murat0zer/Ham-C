package interpreter.visitor;

import interpreter.ast.expression.Expression;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.statement.Statement;
import interpreter.visitor._switch.SwitchUnit;
import interpreter.visitor._switch.SwitchVisitor;
import interpreter.visitor._switch.SwitchVisitorImpl;
import interpreter.visitor.struct.GlobalStructUnit;
import interpreter.visitor.struct.StructStatement;
import interpreter.visitor.struct.StructVisitor;
import interpreter.visitor.struct.StructVisitorImpl;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class VisitorVisitor implements AbstractVisitor  {

    private StructVisitor structVisitor = new StructVisitorImpl();

    private SwitchVisitor switchVisitor = new SwitchVisitorImpl();

    @Override
    public Object visit(Expression expression) {
        return null;
    }

    @Override
    public Object visit(Statement statement) {
        return null;
    }

    public Object visit(StructStatement structStatement) {
        return structVisitor.visit(structStatement);
    }

    public Object visit(GlobalStructUnit globalStructUnit) {
        return structVisitor.visit(globalStructUnit);

    }

    @Override
    public Object visit(SwitchUnit switchUnit) {
        return switchVisitor.visit(switchUnit);
    }

    public Object visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit){
         return abstractGlobalScopeUnit.accept(this);
    }
}
