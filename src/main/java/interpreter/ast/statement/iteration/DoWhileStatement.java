package interpreter.ast.statement.iteration;

import interpreter.ast.expression.Expression;
import interpreter.ast.statement.Statement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.iteration.IterationUnit;
import interpreter.visitor.iteration.IterationVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class DoWhileStatement extends IterationStatement implements IterationUnit {

    public DoWhileStatement(Expression boolExpression, Statement iterationBody) {
        super(boolExpression, iterationBody);
    }

    @Override
    public Object accept(AbstractVisitor v) {
        v.visit(this);
        return null;
    }

    @Override
    public Object accept(IterationVisitor iterationVisitor) {
        return iterationVisitor.visit(this);
    }
}
