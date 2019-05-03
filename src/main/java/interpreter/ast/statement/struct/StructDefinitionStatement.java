package interpreter.ast.statement.struct;

import interpreter.ast.statement.VariableDeclarationStatement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.struct.StructStatement;
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
public class StructDefinitionStatement implements StructStatement {

    private String structId;
    private Set<VariableDeclarationStatement> statements;
    private Object constToken;

    public Object accept(AbstractVisitor v) {
      return  v.visit(this);
    }

    @Override
    public Object accept(StructVisitor structVisitor) {
        return structVisitor.visit(this);
    }
}
