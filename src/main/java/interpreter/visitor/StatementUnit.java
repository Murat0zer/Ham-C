package interpreter.visitor;

import interpreter.ast.statement.Statement;

public interface StatementUnit extends Statement {

    Object accept(EvalVisitor evalVisitor);
}
