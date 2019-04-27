package interpreter.ast.expression.constant;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoubleConst implements Expression {

    private double doubleConst;

    public DoubleConst(double doubleValue) {
        doubleConst = doubleValue;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
