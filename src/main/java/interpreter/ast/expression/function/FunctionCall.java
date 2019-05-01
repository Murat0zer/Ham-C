package interpreter.ast.expression.function;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.function.FunctionCallUnit;
import interpreter.visitor.function.FunctionVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FunctionCall implements FunctionCallUnit {

    private String functionId;

    private Expression primaryExpressionPrime;

    @Override
    public Object accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visit(this);
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
