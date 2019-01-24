package interpreter.ast.globalscope;

import interpreter.Visitor;

public class SimpleInitializer extends AbstractGlobalScopeUnit {

    public SimpleInitializer() {
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
