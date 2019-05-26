package interpreter.visitor._switch;

import interpreter.MyInterpreter;
import interpreter.ast.expression.logical.BoolExpression;
import interpreter.ast.statement._switch.LabelBlock;
import interpreter.ast.statement._switch.LabelStatement;
import interpreter.ast.statement._switch.SwitchBlock;
import interpreter.ast.statement._switch.SwitchStatement;
import interpreter.visitor.struct.GlobalStructUnit;
import interpreter.visitor.struct.StructStatement;

import java.util.Objects;

public class SwitchVisitorImpl implements SwitchVisitor {


    @Override
    public Object visit(SwitchUnit switchUnit) {
        return switchUnit.accept(this);
    }

    @Override
    public Object visit(GlobalStructUnit globalStructUnit) {
        return globalStructUnit.accept(MyInterpreter.visitorSelector);
    }

    @Override
    public Object visit(StructStatement structStatement) {
        return structStatement.accept(MyInterpreter.visitorSelector);
    }

    @Override
    public Object visit(LabelStatement statement) {

        return statement.getStatementList().accept(MyInterpreter.visitorSelector);
    }


    @Override
    public Object visit(SwitchBlock statement) {

        LabelBlock labelBlock = ((LabelBlock) statement.getLabelBlock());
        BoolExpression isDefaultLabel = new BoolExpression(
                Objects.isNull(labelBlock.getLabelExpression()));

        if (isDefaultLabel.isBoolValue())
            SwitchBlock.setDefaultStatement(labelBlock.getLabelStatement());

        // burdan null donerse eşleşen case bulunmamıştır
        // eger default label ise ignore ediyoruz.
        if (!isDefaultLabel.isBoolValue())
            SwitchBlock.setIsCaseFound(
                    new BoolExpression(Objects.nonNull(statement.getLabelBlock().accept(MyInterpreter.visitorSelector))));

        // eger null ise. butun switch caseleri denenmis ve istenilen sonuc bulunamamistir.
        boolean hasMoreLabelBlocks;
        hasMoreLabelBlocks = (Objects.nonNull(statement.getSwitchBlock()));


        if (!SwitchBlock.getIsCaseFound().isBoolValue() && hasMoreLabelBlocks) {
            statement.getSwitchBlock().accept(MyInterpreter.visitorSelector);
            return null;
        }
        boolean isDefaultCaseExists = Objects.nonNull(SwitchBlock.getDefaultStatement());
        if (!SwitchBlock.getIsCaseFound().isBoolValue() && !hasMoreLabelBlocks && isDefaultCaseExists)
            SwitchBlock.getDefaultStatement().accept(MyInterpreter.visitorSelector);
        return null;
    }

    @Override
    public Object visit(SwitchStatement statement) {

        return statement.getSwitchBlock().accept(MyInterpreter.visitorSelector);
    }

    @Override
    public Object visit(LabelBlock statement) {

        Object labelExpression = statement.getLabelExpression().accept(MyInterpreter.visitorSelector);
        Object switchExpression = statement.getSwitchExpression().accept(MyInterpreter.visitorSelector);

        if (labelExpression.equals(switchExpression))
            return statement.getLabelStatement().accept(MyInterpreter.visitorSelector);

        return null;
    }
}
