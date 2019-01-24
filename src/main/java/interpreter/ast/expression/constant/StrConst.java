package interpreter.ast.expression.constant;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StrConst extends Expression {

    private String value;

    public StrConst(String value) {
        this.value = value;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
