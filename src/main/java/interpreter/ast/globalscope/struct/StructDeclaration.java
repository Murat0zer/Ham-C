package interpreter.ast.globalscope.struct;

import interpreter.Visitor;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.statement.VariableDeclarationStatement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StructDeclaration extends AbstractGlobalScopeUnit {

    private String structId;
    private Set<VariableDeclarationStatement> statements;
    private Object constToken;

    public void accept(Visitor v) {
        v.visit(this);
        }
}
