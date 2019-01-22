package interpreter;

abstract class AbstractGlobalScopeUnit {
    public abstract void accept(Visitor v);
}

class GlobalVariableDeclaration extends AbstractGlobalScopeUnit {

    public void accept(Visitor v) {
        v.visit(this);
    }
}

class StructDeclaration extends AbstractGlobalScopeUnit {


    public void accept(Visitor v) {
        v.visit(this);
    }
}

class FunctionDeclaration extends AbstractGlobalScopeUnit {

    String id;
    java.util.List parameterList = null;
    Stm s;
    String returnType;

    public FunctionDeclaration(String returnType, String id, java.util.List parameterList, Stm s) {
        this.id = id;
        this.parameterList = parameterList;
        this.s = s;
        this.returnType = returnType;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Variable {
    String type;
    String value;

    public Variable(String type, String value) {
        this.type = type;
        this.value = value;
    }
}

class LogicalOR extends Exp {
    Exp e1, e2;

    public LogicalOR(Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class LogicalAND extends Exp {
    Exp e1, e2;

    public LogicalAND(Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class EqualityExpression extends Exp {
    Exp e1, e2;
    String operatorType;

    public EqualityExpression(Exp e1, Exp e2, String operatorType) {
        this.e1 = e1;
        this.e2 = e2;
        this.operatorType = operatorType;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class RelationalExpression extends Exp {
    Exp e1, e2;
    String operatorType;

    public RelationalExpression(Exp e1, Exp e2, String operatorType) {
        this.e1 = e1;
        this.e2 = e2;
        this.operatorType = operatorType;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class AdditiveExpression extends Exp {
    Exp e1, e2;
    String operatorType;

    public AdditiveExpression(Exp e1, Exp e2, String operatorType) {
        this.e1 = e1;
        this.e2 = e2;
        this.operatorType = operatorType;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class MultiplicativeExpression extends Exp {
    Exp e1, e2;
    String operatorType;

    public MultiplicativeExpression(Exp e1, Exp e2, String operatorType) {
        this.e1 = e1;
        this.e2 = e2;
        this.operatorType = operatorType;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class ExponentialExpression extends Exp {
    Exp e1, e2;

    public ExponentialExpression(Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

class UnaryExpression extends Exp {
    Exp e1;
    String unaryOp = null;

    public UnaryExpression(Exp e1, String unaryOp) {
        this.e1 = e1;
        this.unaryOp = unaryOp;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class PostfixExpression extends Exp {
    Exp e1, e2;
    String id = null;

    public PostfixExpression(Exp e1, Exp e2, String id) {
        this.e1 = e1;
        this.e2 = e2;
        this.id = id;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class BNum extends Exp {
    boolean n;

    public BNum(boolean a) {
        n = a;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

class PrimaryExpression extends Exp {
    Exp e1;

    public PrimaryExpression(Exp e1) {
        this.e1 = e1;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

abstract class Exp {
    public abstract Object accept(Visitor v);
}

class StrConst extends Exp {
    String value;

    public StrConst(String value) {
        this.value = value;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

class IntConst extends Exp {
    int constInt;

    public IntConst(int integer) {
        constInt = integer;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

class ConstantExpression extends Exp {

    Exp e;

    public ConstantExpression(Exp e) {
        this.e = e;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class ExpList extends Exp {

    Exp e1, e2;

    public ExpList(Exp e1, Exp e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}

class PrimaryExpressionPrime extends Exp {

    public Object accept(Visitor v) {
        return v.visit(this);
    }

}



class Call extends Exp {
    String id;
    Exp e;

    public Call(String a, Exp b) {
        id = a;
        e = b;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

class Seq extends Exp {
    Stm s;
    Exp e;

    public Seq(Stm a, Exp b) {
        s = a;
        e = b;
    }

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}

abstract class Stm {
    public abstract void accept(Visitor v);
}

class StmList extends Stm {
    Stm s1, s2;

    public StmList(Stm a, Stm b) {
        s1 = a;
        s2 = b;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}


class Asgn extends Stm {
    String id;
    Exp e;

    public Asgn(String a, Exp b) {
        id = a;
        e = b;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

class Print extends Stm {
    Exp e;

    public Print(Exp a) {
        e = a;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}

