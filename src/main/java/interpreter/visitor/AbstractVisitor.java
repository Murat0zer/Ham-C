
package interpreter.visitor;

import interpreter.ast.expression.Expression;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.visitor._switch.SwitchUnit;
import interpreter.visitor.arithmetic.ArithmeticUnit;
import interpreter.visitor.constant.ConstantUnit;
import interpreter.visitor.flow_control.FlowControlUnit;
import interpreter.visitor.function.FunctionCallUnit;
import interpreter.visitor.function.FunctionDefinitionUnit;
import interpreter.visitor.iteration.IterationUnit;
import interpreter.visitor.logical.LogicalUnit;
import interpreter.visitor.struct.GlobalStructUnit;
import interpreter.visitor.struct.StructStatement;

public interface AbstractVisitor {

  default Object visit(GlobalStructUnit globalStructUnit) { return null; }

  default Object visit(StructStatement structStatement) { return null;  }

  default Object visit(SwitchUnit switchUnit) { return null; }

  default Object visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) { return null; }

  default Object visit(FunctionDefinitionUnit functionDefinitionUnit) { return null; }

  default Object visit(FunctionCallUnit functionCallUnit) { return  null; }

  default Object visit(IterationUnit iterationUnit) { return null; }

  default Object visit(FlowControlUnit flowControlUnit) { return null; }

  default Object visit(StatementUnit statementUnit) { return null; }

  default Object visit(ExpressionUnit expressionUnit) { return null; }

  default Object visit(LogicalUnit logicalUnit) { return null; }

  default Object visit(ArithmeticUnit arithmeticUnit) { return null; }

  default Object visit(ConstantUnit constantUnit) { return null; }

  default Object visit(GlobalUnit globalUnit) { return null; }
}
