package interpreter.visitor;

import interpreter.ast.expression.Expression;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.statement.Statement;
import interpreter.visitor._switch.SwitchUnit;
import interpreter.visitor.struct.GlobalStructUnit;

public interface AbstractVisitor {

  default Object visit(GlobalStructUnit globalStructUnit) { return null; }

  default Object visit(Expression expression){ return  null; }

  default Object visit(Statement statement){ return  null; }

  default Object visit(SwitchUnit switchUnit) { return null; }

  default Object visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) { return null; }

}
