package interpreter.visitor.function;

import interpreter.ast.globalscope.AbstractGlobalScopeUnit;

public interface FunctionDefinitionUnit extends AbstractGlobalScopeUnit {

    Object accept(FunctionVisitor functionVisitor);
}
