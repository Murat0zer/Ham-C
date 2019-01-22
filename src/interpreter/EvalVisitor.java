package interpreter;

class EvalVisitor implements Visitor {

    boolean brk = false;
    boolean cnt = false;
    Table table = new Table(1000);

    public void visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) {
    }

    public void visit(FunctionDeclaration functionDeclaration) {
    }

    public void visit(StructDeclaration structDeclaration) {
    }

    public void visit(GlobalVariableDeclaration globalVariableDeclaration) {
    }

    public Object visit(IntConst exp) {
        return exp.constInt;
    }

    public Object visit(StrConst exp) {
        return exp.value;
    }

    public void visit(StmList s) {
        s.s1.accept(this);
        if (!(brk || cnt))
            s.s2.accept(this);
    }

    public Object visit(Exp e) {
        return e.accept(this);
    }



    public void visit(Stm s) {
        s.accept(this);
    }


    public void visit(Print s) {
        System.out.println(s.e.accept(this));
    }


    @Override
    public Exp visit(LogicalOR e) {
        return null;
    }

    @Override
    public Exp visit(LogicalAND e) {
        return null;
    }

    @Override
    public Exp visit(EqualityExpression e) {
        return null;
    }

    @Override
    public Exp visit(RelationalExpression e) {
        return null;
    }

    @Override
    public Exp visit(AdditiveExpression e) {
        return null;
    }

    @Override
    public Exp visit(MultiplicativeExpression e) {
        return null;
    }

    @Override
    public Exp visit(ExponentialExpression e) {
        return null;
    }

    @Override
    public Exp visit(UnaryExpression e) {
        return null;
    }

    @Override
    public Exp visit(PrimaryExpression e) {
        return null;
    }

    @Override
    public Exp visit(ConstantExpression e) {
        return null;
    }

    @Override
    public Exp visit(PrimaryExpressionPrime e) {
        return null;
    }

    @Override
    public Exp visit(ExpList e) {
        return null;
    }

    @Override
    public Exp visit(BNum e) {
        return null;
    }
}