package interpreter.ast.statement.struct;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.statement.AssignmentStatement;
import interpreter.visitor.struct.StructStatement;
import interpreter.visitor.struct.StructVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StructAssignmentStatement implements StructStatement {

  private String structInstanceId;
  private Set<AssignmentStatement> statements;
  private String constToken;

  @Override
  public Object accept(AbstractVisitor v) {
    return v.visit(this);
  }

  @Override
  public Object accept(StructVisitor structVisitor) {
    return structVisitor.visit(this);
  }
}
