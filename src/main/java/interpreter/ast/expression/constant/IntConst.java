package interpreter.ast.expression.constant;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.ExpressionUnit;
import interpreter.visitor.constant.ConstantUnit;
import interpreter.visitor.constant.ConstantVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IntConst implements ConstantUnit {

    private int constInt;

    public IntConst(int integer) {
        constInt = integer;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(ConstantVisitor constantVisitor) {
        return constantVisitor.visit(this);
    }
}
