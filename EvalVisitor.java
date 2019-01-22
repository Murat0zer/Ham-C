class EvalVisitor implements Visitor {

    boolean brk = false;
    boolean cnt = false;
    Table table = new Table(1000);

    public void visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) {
        abstractGlobalScopeUnit.accept(this);
    }

    public void visit(FunctionDeclaration functionDeclaration) {
        functionDeclaration.s.accept(this);

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


    public Exp visit(LogicalOR e) {
        System.out.println("test");
        Exp n1 = (Exp) e.e1.accept(this);
        Exp n2 = (Exp) e.e2.accept(this);
        return new BNum(((BNum) n1).n || ((BNum) n2).n);
    }

    @Override
    public Exp visit(LogicalAND e) {
        Exp n1 = (Exp) e.e1.accept(this);
        Exp n2 = (Exp) e.e2.accept(this);
        return new BNum(((BNum) n1).n && ((BNum) n2).n);
    }

    @Override
    public Exp visit(EqualityExpression e) {

        Exp n1 = (Exp) e.e1.accept(this);
        Exp n2 = (Exp) e.e2.accept(this);
        BNum result = new BNum(false);
        switch (e.operatorType) {
            case "==":
                result = new BNum(((BNum) n1).n == ((BNum) n2).n);
                break;
            case "!=":
                result = new BNum(((BNum) n1).n == ((BNum) n2).n);
                break;
        }

        return result;
    }

    @Override
    public Exp visit(RelationalExpression e) {
        Exp n1 = (Exp) e.e1.accept(this);
        Exp n2 = (Exp) e.e2.accept(this);
        return n1;
    }

    @Override
    public Exp visit(AdditiveExpression e) {
        Exp n1 = (Exp) e.e1.accept(this);
        Exp n2 = (Exp) e.e2.accept(this);
        return n1;
    }

    @Override
    public Exp visit(MultiplicativeExpression e) {
        Exp n1 = (Exp) e.e1.accept(this);
        Exp n2 = (Exp) e.e2.accept(this);
        return n1;
    }

    @Override
    public Exp visit(ExponentialExpression e) {
        Exp n1 = (Exp) e.e1.accept(this);
        Exp n2 = (Exp) e.e2.accept(this);
        return n1;
    }

    @Override
    public Object visit(UnaryExpression e) {
        Object n1 = e.e1.accept(this);
        return n1;
    }

    @Override
    public Exp visit(PrimaryExpression e) {
        Exp n1 = (Exp) e.e1.accept(this);
        return n1;
    }

    @Override
    public Object visit(ConstantExpression e) {
        Object n1 = e.e.accept(this);
        return n1;
    }

    @Override
    public Exp visit(PrimaryExpressionPrime e) {
        Exp n1 = (Exp) e.e1.accept(this);
        return n1;
    }

    @Override
    public Exp visit(ExpList e) {
        return null;
    }

    @Override
    public Exp visit(BNum e) {
        return e;
    }

    @Override
    public Object visit(PostfixExpression e) {
        return null;
    }

    @Override
    public void visit(StructMemberDeclaration structMemberDeclaration) {

    }

    @Override
    public void visit(SimpleInitializer simpleInitializer) {

    }

    @Override
    public void visit(StructInitializer structInitializer) {

    }


}