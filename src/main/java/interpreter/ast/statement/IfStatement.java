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
public class IfStatement extends Statement {

    private Expression boolExpression;
    private Statement trueBlock;
    private Statement elseBlock;

    public Object accept(Visitor v) {
       return v.visit(this);
    }
}
