package interpreter.ast.statement;

import interpreter.Visitor;
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
