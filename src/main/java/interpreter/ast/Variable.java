
package interpreter.ast;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.ExpressionUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Variable implements ExpressionUnit {

    private String type;
    private String id;

    public Variable(String type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(EvalVisitor evalVisitor) {
        return evalVisitor.visit(this);
    }
}


