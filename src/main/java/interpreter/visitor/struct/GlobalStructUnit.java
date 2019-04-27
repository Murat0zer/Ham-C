package interpreter.visitor.struct;

import interpreter.ast.globalscope.AbstractGlobalScopeUnit;

public interface GlobalStructUnit extends AbstractGlobalScopeUnit {

    Object accept(StructVisitor structVisitor);
}

