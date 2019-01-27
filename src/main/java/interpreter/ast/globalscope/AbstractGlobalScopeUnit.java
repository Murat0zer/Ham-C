package interpreter.ast.globalscope;

import interpreter.Visitor;

public abstract class AbstractGlobalScopeUnit  {
    public abstract void accept(Visitor v);
}
