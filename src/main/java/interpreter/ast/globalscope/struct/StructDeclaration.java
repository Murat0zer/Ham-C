package interpreter.ast.globalscope.struct;

import interpreter.Visitor;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;

public class StructDeclaration extends AbstractGlobalScopeUnit {
    public StructDeclaration() {
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
