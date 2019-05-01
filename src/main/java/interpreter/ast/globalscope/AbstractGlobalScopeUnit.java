package interpreter.ast.globalscope;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;

public interface AbstractGlobalScopeUnit {
    Object accept(AbstractVisitor v);

}
