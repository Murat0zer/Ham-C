package interpreter.ast.globalscope.struct;

import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.visitor.AbstractVisitor;

public class StructMemberDeclaration implements AbstractGlobalScopeUnit {

    public StructMemberDeclaration() {
    }

    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }
}
