package interpreter.visitor.iteration;


import interpreter.ast.statement.Statement;

public interface IterationUnit extends Statement {

    Object accept(IterationVisitor iterationVisitor);
}
