package interpreter.visitor.constant;

import interpreter.ast.expression.constant.ConstantExpression;
import interpreter.ast.expression.constant.DoubleConst;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;

public class ConstantVisitorImpl  implements ConstantVisitor {



    @Override
    public Object visit(IntConst exp) {
        return exp.getConstInt();
    }

    @Override
    public Object visit(StrConst exp) {
        exp.setValue(exp.getValue().replace("\"", ""));
        return exp.getValue();
    }

    @Override
    public Object visit(DoubleConst exp) {
        return exp.getDoubleConst();
    }


    @Override
    public Object visit(ConstantExpression e) {
        return e.getConstantValue().accept(this);
    }

    @Override
    public Object visit(ConstantUnit constantUnit) {
        return constantUnit.accept(this);
    }
}
