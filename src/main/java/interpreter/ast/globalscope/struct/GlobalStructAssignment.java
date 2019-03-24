package interpreter.ast.globalscope.struct;

import interpreter.Visitor;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.statement.AssignmentStatement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GlobalStructAssignment extends AbstractGlobalScopeUnit {

  private String structInstanceId;
  private Set<AssignmentStatement> statements;
  private Object constToken;

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
