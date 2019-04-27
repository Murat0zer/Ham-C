package interpreter.visitor.struct;


import interpreter.ast.statement.Statement;

public interface StructStatement extends Statement {

    Object accept(StructVisitor structVisitor);

}
