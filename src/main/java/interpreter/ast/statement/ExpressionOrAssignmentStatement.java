package interpreter.ast.statement;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExpressionOrAssignmentStatement extends Statement {

    private Expression left;
    private Expression right;

    public Object accept(Visitor v) {
       return v.visit(this);
    }
}
