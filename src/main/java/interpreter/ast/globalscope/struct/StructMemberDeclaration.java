package interpreter.ast.globalscope.struct;

import interpreter.Visitor;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;

public class StructMemberDeclaration extends AbstractGlobalScopeUnit {

    public StructMemberDeclaration() {
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
