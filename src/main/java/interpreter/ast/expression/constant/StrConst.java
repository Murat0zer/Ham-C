package interpreter.ast.expression.constant;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.constant.ConstantUnit;
import interpreter.visitor.constant.ConstantVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StrConst implements ConstantUnit {

    private String value;

    public StrConst(String value) {
        this.value = value;
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
