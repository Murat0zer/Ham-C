package interpreter.ast.statement;

import interpreter.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StructDefinitionStatement extends Statement {

  private String type;
  private String id;
  private Set<VariableDeclarationStatement> statements;
  private Object constToken;

  @Override
  public Object accept(Visitor v) {
     return v.visit(this);
  }
}
