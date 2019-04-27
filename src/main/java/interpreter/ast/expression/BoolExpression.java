package interpreter.ast.expression;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.EvalVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoolExpression implements Expression {

    private boolean boolValue;

    public BoolExpression(boolean a) {
        boolValue = a;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
