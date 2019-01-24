package interpreter.ast.expression.constant;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoubleConst extends Expression {

    private double doubleConst;

    public DoubleConst(double doubleValue) {
        doubleConst = doubleValue;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
