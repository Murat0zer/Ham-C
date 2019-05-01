package interpreter.visitor;

import interpreter.ast.globalscope.AbstractGlobalScopeUnit;

public interface GlobalUnit extends AbstractGlobalScopeUnit {
    Object accept(EvalVisitor evalVisitor);
}
