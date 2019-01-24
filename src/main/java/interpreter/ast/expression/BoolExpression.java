package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoolExpression extends Expression {

    private boolean boolValue;

    public BoolExpression(boolean a) {
        boolValue = a;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
