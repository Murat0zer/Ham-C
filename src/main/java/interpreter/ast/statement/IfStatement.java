package interpreter.ast.statement;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IfStatement implements Statement {

    private Expression boolExpression;
    private Statement trueBlock;
    private Statement elseBlock;

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
