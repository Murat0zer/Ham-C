package interpreter.ast.globalscope;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import interpreter.ast.globalscope.struct.StructInitializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SimpleInitializer extends Expression {

    private Expression expression;

    private StructInitializer structInitializer;

    public SimpleInitializer(Expression expression) {
        this.expression = expression;
    }

    public SimpleInitializer(StructInitializer structInitializer) {
        this.structInitializer = structInitializer;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
