package interpreter.ast.globalscope.struct;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.statement.VariableDeclarationStatement;
import interpreter.visitor.struct.GlobalStructUnit;
import interpreter.visitor.struct.StructVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GlobalStructDefinition implements GlobalStructUnit {

    private String structId;
    private Set<VariableDeclarationStatement> statements;
    private Object constToken;

    @Override
    public Object accept(AbstractVisitor v) {
       return  v.visit(this);

    }

    @Override
    public Object accept(StructVisitor structVisitor) {
        return structVisitor.visit(this);
    }
}
