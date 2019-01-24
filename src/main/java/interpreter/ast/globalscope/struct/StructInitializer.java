package interpreter.ast.globalscope.struct;

import interpreter.Visitor;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;

public class StructInitializer extends AbstractGlobalScopeUnit {

    public StructInitializer() {
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
