package interpreter.ast.globalscope;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GlobalVariableDeclaration extends AbstractGlobalScopeUnit {

    private String type;
    private String id;
    private Expression value;
    private Object constToken;

    public GlobalVariableDeclaration(String type, String id, Expression value, Object constToken) {
        this.type = type;
        this.id = id;
        this.value = value;
        this.constToken = constToken;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
