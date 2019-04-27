package interpreter.ast.globalscope;

import interpreter.ast.expression.Expression;
import interpreter.ast.globalscope.struct.StructInitializer;
import interpreter.visitor.AbstractVisitor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SimpleInitializer implements Expression {

    private Expression expression;

    private StructInitializer structInitializer;

    public SimpleInitializer(Expression expression) {
        this.expression = expression;
    }

    public SimpleInitializer(StructInitializer structInitializer) {
        this.structInitializer = structInitializer;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
