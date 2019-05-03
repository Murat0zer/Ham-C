package interpreter.ast.globalscope.struct;

import interpreter.ast.expression.Expression;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.struct.StructVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StructInitializer implements AbstractGlobalScopeUnit {

    private Expression expressions;

    @Override
    public Object accept(AbstractVisitor v) {
        ((StructVisitor)v).visit(this);
        return null;
    }
}
