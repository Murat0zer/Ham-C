package interpreter.ast.globalscope;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.GlobalUnit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class GlobalVariableDeclaration implements GlobalUnit {

    private String type;
    private String id;
    private Expression value;
    private Object constToken;

    @Override
    public Object accept(AbstractVisitor v)  {
        return v.visit(this);
    }

    @Override
    public Object accept(EvalVisitor evalVisitor) {
        return evalVisitor.visit(this);
    }
}
