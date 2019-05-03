package interpreter.ast.globalscope.struct;

import interpreter.ast.statement.VariableDeclarationStatement;
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
public class GlobalStructDeclaration implements GlobalStructUnit {

  private String structId;
  private String structInstanceId;
  private Set<VariableDeclarationStatement> statements;
  private Object constToken;

  @Override
  public Object accept(StructVisitor v) {
    return v.visit(this);

  }

  @Override
  public Object accept(AbstractVisitor v) {
    return v.visit(this);
  }
}
