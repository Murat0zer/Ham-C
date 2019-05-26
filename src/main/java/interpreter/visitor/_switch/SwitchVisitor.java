package interpreter.visitor._switch;

import interpreter.ast.statement._switch.LabelBlock;
import interpreter.ast.statement._switch.LabelStatement;
import interpreter.ast.statement._switch.SwitchBlock;
import interpreter.ast.statement._switch.SwitchStatement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.struct.GlobalStructUnit;
import interpreter.visitor.struct.StructStatement;

public interface SwitchVisitor extends AbstractVisitor {

    @Override
    Object visit(GlobalStructUnit globalStructUnit);

    @Override
    Object visit(StructStatement structStatement);

    @Override
    Object visit(SwitchUnit switchUnit);

    Object visit(LabelStatement statement);

    Object visit(SwitchBlock statement);

    Object visit(SwitchStatement statement);

    Object visit(LabelBlock statement);

}
