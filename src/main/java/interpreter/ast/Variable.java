
package interpreter.ast;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Variable extends Expression {

    private String type;
    private String value;

    public Variable(String type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}


