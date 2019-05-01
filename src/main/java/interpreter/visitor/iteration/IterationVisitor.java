package interpreter.visitor.iteration;

import interpreter.ast.statement.iteration.DoWhileStatement;
import interpreter.ast.statement.iteration.ForStatement;
import interpreter.ast.statement.iteration.IterationStatement;
import interpreter.ast.statement.iteration.WhileStatement;
import interpreter.visitor.AbstractVisitor;

public interface IterationVisitor extends AbstractVisitor {



    @Override
    Object visit(IterationUnit iterationUnit);

    Object visit(WhileStatement statement);

    Object visit(DoWhileStatement statement);

    Object visit(ForStatement statement);

    Object visit(IterationStatement statement);




}
