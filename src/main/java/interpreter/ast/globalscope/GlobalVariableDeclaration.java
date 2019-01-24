package interpreter.ast.globalscope;

import interpreter.Visitor;

public class GlobalVariableDeclaration extends AbstractGlobalScopeUnit {
    AbstractGlobalScopeUnit abstractGlobalScopeUnit;
    public GlobalVariableDeclaration() {
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
