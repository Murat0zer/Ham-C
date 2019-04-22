package interpreter.ast.statement.struct;

import interpreter.Visitor;
import interpreter.ast.statement.AssignmentStatement;
import interpreter.ast.statement.Statement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StructAssignmentStatement extends Statement {

  private String structInstanceId;
  private Set<AssignmentStatement> statements;
  private String constToken;

  @Override
  public Object accept(Visitor v) {
    return v.visit(this);
  }

}
