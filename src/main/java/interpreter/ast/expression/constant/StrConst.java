package interpreter.ast.expression.constant;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StrConst implements Expression {

    private String value;

    public StrConst(String value) {
        this.value = value;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
