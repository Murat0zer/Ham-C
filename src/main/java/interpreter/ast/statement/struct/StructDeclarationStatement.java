package interpreter.ast.statement.struct;

import interpreter.Visitor;
import interpreter.ast.statement.Statement;
import interpreter.ast.statement.VariableDeclarationStatement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StructDeclarationStatement extends Statement {

  private String structId;
  private String structInstanceId;
  private Set<VariableDeclarationStatement> statements;
  private Object constToken;

  @Override
  public Object accept(Visitor v) {
     return v.visit(this);
  }
}
