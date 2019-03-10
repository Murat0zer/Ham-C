package interpreter.ast.expression.constant;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntConst extends Expression {

    private int constInt;

    public IntConst(int integer) {
        constInt = integer;
    }

    public Object accept(Visitor v) {
            return v.visit(this);
    }
}
