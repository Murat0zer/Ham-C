package interpreter;
public interface Visitor {

    public void visit(Stm s);
    public void visit(Print s);

    public Object visit(IntConst exp);
    public Object visit(StrConst exp);

    public void visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit);
    public void visit(GlobalVariableDeclaration globalVariableDeclaration);
    public void visit(StructDeclaration structDeclaration);
    public void visit(FunctionDeclaration functionDeclaration);


    Object visit(LogicalOR e);
    public Object visit(LogicalAND e);
    public Object visit(EqualityExpression e);
    public Object visit(RelationalExpression e);
    public Object visit(AdditiveExpression e);
    public Object visit(MultiplicativeExpression e);
    public Object visit(ExponentialExpression e);
    public Object visit(UnaryExpression e);
    public Object visit(PrimaryExpression e);
    public Object visit(ConstantExpression e);
    public Object visit(Exp e);
    public Object visit(PrimaryExpressionPrime e);
    public Object visit(ExpList e);
    public Object visit(BNum e);

}