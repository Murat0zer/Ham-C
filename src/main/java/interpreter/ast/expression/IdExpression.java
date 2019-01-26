package interpreter.ast.expression;

import interpreter.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IdExpression extends  Expression {

    private String id;

    @Override
    public Object accept(Visitor v) {
      return  v.visit(this);
    }
}
