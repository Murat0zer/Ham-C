package interpreter.ast;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
import interpreter.ast.statement.SwitchStatement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LabelBlock extends Statement {

    private Expression labelExpression;
    private Statement labelStatement;
    private Expression switchExpression;


    public Object accept(Visitor v) {
       return v.visit(this);
    }
}
