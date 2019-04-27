package interpreter.ast.globalscope.struct;

import interpreter.visitor.AbstractVisitor;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;

public class StructMemberDeclaration implements AbstractGlobalScopeUnit {

    public StructMemberDeclaration() {
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
