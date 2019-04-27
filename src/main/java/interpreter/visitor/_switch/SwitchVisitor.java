package interpreter.visitor._switch;

import interpreter.ast.statement._switch.LabelBlock;
import interpreter.ast.statement._switch.LabelStatement;
import interpreter.ast.statement._switch.SwitchBlock;
import interpreter.ast.statement._switch.SwitchStatement;
import interpreter.visitor.AbstractVisitor;

public interface SwitchVisitor extends AbstractVisitor {

    @Override
    Object visit(SwitchUnit switchUnit);

    Object visit(LabelStatement statement);

    Object visit(SwitchBlock statement);

    Object visit(SwitchStatement statement);

    Object visit(LabelBlock statement);

}
