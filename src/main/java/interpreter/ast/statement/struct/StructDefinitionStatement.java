package interpreter.ast.statement.struct;

import interpreter.Visitor;
import interpreter.ast.statement.Statement;
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
public class StructDefinitionStatement extends Statement {

    private String structId;
    private Set<VariableDeclarationStatement> statements;
    private Object constToken;

    public Object accept(Visitor v) {
      return  v.visit(this);
    }
}
