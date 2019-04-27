package interpreter.ast.statement.iteration;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForStatement extends IterationStatement {

    private Statement forIndex;
    private Statement forIncrement;

    public ForStatement(Expression boolExpression, Statement iterationBody, Statement forIndex, Statement forIncrement) {
        super(boolExpression, iterationBody);
        this.forIndex = forIndex;
        this.forIncrement = forIncrement;
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
