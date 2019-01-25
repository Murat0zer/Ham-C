package interpreter.ast;

import interpreter.Visitor;
import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LabelBlock extends Statement {

    private Expression constantExpression;
    private Statement labelStatement;

    public Object accept(Visitor v) {
       return v.visit(this);
    }
}
