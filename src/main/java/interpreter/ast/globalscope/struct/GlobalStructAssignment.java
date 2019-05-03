package interpreter.ast.globalscope.struct;

import interpreter.ast.statement.AssignmentStatement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.struct.GlobalStructUnit;
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
public class GlobalStructAssignment implements GlobalStructUnit {

  private String structInstanceId;
  private Set<AssignmentStatement> statements;
  private Object constToken;

  @Override
  public Object accept(AbstractVisitor v) {
    return v.visit(this);
  }

  @Override
  public Object accept(StructVisitor structVisitor) {
    return structVisitor.visit(this);
  }
}
