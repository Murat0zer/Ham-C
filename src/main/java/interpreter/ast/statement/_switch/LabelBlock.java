package interpreter.ast.statement._switch;

import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor._switch.SwitchUnit;
import interpreter.visitor._switch.SwitchVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LabelBlock implements SwitchUnit {

    private Expression labelExpression;
    private Statement labelStatement;
    private Expression switchExpression;


    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(SwitchVisitor switchVisitor) {
        return switchVisitor.visit(this);
    }
}
