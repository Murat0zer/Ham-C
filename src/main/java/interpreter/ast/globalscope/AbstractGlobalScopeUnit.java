package interpreter.ast.globalscope;

import interpreter.visitor.AbstractVisitor;

public interface AbstractGlobalScopeUnit {
    Object accept(AbstractVisitor v);
}
