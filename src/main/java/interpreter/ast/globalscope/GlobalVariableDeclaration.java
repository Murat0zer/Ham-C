package interpreter.ast.globalscope;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class GlobalVariableDeclaration extends AbstractGlobalScopeUnit {

    private String type;
    private String id;
    private Expression value;
    private Object constToken;

    public void accept(Visitor v) {
        v.visit(this);
    }
}
