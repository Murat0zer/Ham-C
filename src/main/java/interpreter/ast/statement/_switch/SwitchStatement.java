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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SwitchStatement implements SwitchUnit {

    private Expression switchExpression;
    private Statement switchBlock;

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);

    }

    @Override
    public Object accept(SwitchVisitor switchVisitor) {
        return switchVisitor.visit(this);
    }
}
