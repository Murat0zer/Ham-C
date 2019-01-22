
interface Visitor {

    void visit(Stm s);

    void visit(Print s);

    Object visit(IntConst exp);

    Object visit(StrConst exp);

    void visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit);

    void visit(GlobalVariableDeclaration globalVariableDeclaration);

    void visit(StructDeclaration structDeclaration);

    void visit(StructMemberDeclaration structMemberDeclaration);

    void visit(FunctionDeclaration functionDeclaration);

    void visit (StructInitializer structInitializer);

    void visit (SimpleInitializer simpleInitializer);

    Object visit(LogicalOR e);

    Object visit(LogicalAND e);

    Object visit(EqualityExpression e);

    Object visit(RelationalExpression e);

    Object visit(AdditiveExpression e);

    Object visit(MultiplicativeExpression e);

    Object visit(ExponentialExpression e);

    Object visit(UnaryExpression e);

    Object visit(PrimaryExpression e);

    Object visit(ConstantExpression e);

    Object visit(Exp e);

    Object visit(PostfixExpression e);

    Object visit(PrimaryExpressionPrime e);

    Object visit(ExpList e);

    Object visit(BNum e);

}