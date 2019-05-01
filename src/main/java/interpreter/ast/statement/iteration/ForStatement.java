package interpreter.ast.statement.iteration;

import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.iteration.IterationUnit;
import interpreter.visitor.iteration.IterationVisitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForStatement extends IterationStatement implements IterationUnit  {

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
    }

    @Override
    public Object accept(IterationVisitor iterationVisitor) {
        return iterationVisitor.visit(this);
    }
}
