package interpreter.visitor._switch;

import interpreter.ast.statement.Statement;

public interface SwitchUnit extends Statement {

    Object accept(SwitchVisitor switchVisitor);
}
