package interpreter.ast.statement;

import interpreter.Visitor;
import interpreter.ast.expression.BoolExpression;
import interpreter.ast.expression.Expression;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwitchBlock extends Statement {

    private static Statement defaultStatement = null;
    private static BoolExpression isCaseFound = new BoolExpression(false);
    private Statement labelBlock;
    private Statement switchBlock;

    public Object accept(Visitor v) {
        return v.visit(this);
    }

    public static Statement getDefaultStatement() {
        return defaultStatement;
    }

    public static void setDefaultStatement(Statement defaultStatement) {
        SwitchBlock.defaultStatement = defaultStatement;
    }

    public static BoolExpression getIsCaseFound() {
        return isCaseFound;
    }

    public static void setIsCaseFound(BoolExpression isCaseFound) {
        SwitchBlock.isCaseFound = isCaseFound;
    }
}
