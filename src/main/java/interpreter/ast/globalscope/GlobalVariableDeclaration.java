package interpreter.ast.globalscope;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class GlobalVariableDeclaration implements AbstractGlobalScopeUnit {

    private String type;
    private String id;
    private Expression value;
    private Object constToken;

    @Override
    public Object accept(AbstractVisitor v)  {
        return v.visit(this);
    }
}
