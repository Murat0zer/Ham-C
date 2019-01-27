package interpreter.ast.globalscope;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SimpleInitializer extends Expression {

    private Expression expression;

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
