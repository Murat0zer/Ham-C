
package interpreter.ast;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Variable implements Expression {

    private String type;
    private String value;

    public Variable(String type, String value) {
        this.type = type;
        this.value = value;
    }

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}


