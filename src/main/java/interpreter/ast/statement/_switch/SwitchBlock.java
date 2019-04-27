package interpreter.ast.statement._switch;

import interpreter.ast.expression.BoolExpression;
import interpreter.ast.statement.Statement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor._switch.SwitchUnit;
import interpreter.visitor._switch.SwitchVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwitchBlock implements SwitchUnit {

    // TODO: 27.04.2019 make it thread safe.
    private static Statement defaultStatement = null;
    private static BoolExpression isCaseFound = new BoolExpression(false);
    private Statement labelBlock;
    private Statement switchBlock;

    public static BoolExpression getIsCaseFound() {
        return isCaseFound;
    }

    public static void setIsCaseFound(BoolExpression isCaseFound) {
        SwitchBlock.isCaseFound = isCaseFound;
    }

    public static Statement getDefaultStatement() {
        return defaultStatement;
    }

    public static void setDefaultStatement(Statement defaultStatement) {
        SwitchBlock.defaultStatement = defaultStatement;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(SwitchVisitor switchVisitor) {
        return switchVisitor.visit(this);
    }
}
