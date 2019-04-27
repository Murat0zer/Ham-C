package interpreter.ast.expression.constant;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntConst implements Expression {

    private int constInt;

    public IntConst(int integer) {
        constInt = integer;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
