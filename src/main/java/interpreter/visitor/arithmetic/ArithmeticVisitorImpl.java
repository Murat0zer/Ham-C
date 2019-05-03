package interpreter.visitor.arithmetic;

import interpreter.MyInterpreter;
import interpreter.ast.expression.ExponentialExpression;
import interpreter.ast.expression.Expression;
import interpreter.ast.expression.arithmetic.additive.MinusExpression;
import interpreter.ast.expression.arithmetic.additive.PlusExpression;
import interpreter.ast.expression.arithmetic.multiplicative.DivideExpression;
import interpreter.ast.expression.arithmetic.multiplicative.TimesExpression;
import interpreter.ast.expression.constant.DoubleConst;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;
import interpreter.ast.statement.Statement;
import interpreter.ast.statement.StatementList;
import interpreter.visitor.VisitorVisitor;
import interpreter.visitor.constant.ConstantUnit;

public class ArithmeticVisitorImpl extends VisitorVisitor implements ArithmeticVisitor {


    @Override
    public Object visit(ArithmeticUnit arithmeticUnit) {
        return arithmeticUnit.accept(this);
    }



    @Override
    public Object visit(PlusExpression expression) {

        Object left = expression.getLeft().accept(MyInterpreter.visitorSelector);
        Object right = expression.getRight().accept(MyInterpreter.visitorSelector);

        while(!(left instanceof Integer || left instanceof  String)) {
            if(left instanceof Statement)
                return  ((Statement)left).accept(MyInterpreter.visitorSelector);
            else if (left instanceof Expression)
                left = ((Expression)left).accept(MyInterpreter.visitorSelector);
        }
        while(!(right instanceof Integer || right instanceof  String)) {
            if(right instanceof Statement)
                return  ((Statement)right).accept(MyInterpreter.visitorSelector);
            else if (right instanceof Expression)
                right = ((Expression)right).accept(MyInterpreter.visitorSelector);
            if (right == null)
                return left;
        }

        expression.setLeftType(left.getClass().getSimpleName());
        expression.setRightType(right.getClass().getSimpleName());

        if (expression.getLeftType().equals("String") || expression.getRightType().equals("String")) {
            return new StrConst(((String) left) + right).getValue();
        } else if (expression.getLeftType().equals("Integer") || expression.getRightType().equals(
                "Integer"))
            return new IntConst((Integer) left + (Integer) right).getConstInt();
        else
            return new DoubleConst((Double) left + (Double) right).getDoubleConst();

    }

    @Override
    public Object visit(MinusExpression expression) {

        Object left = expression.getLeft().accept(MyInterpreter.visitorSelector);
        Object right = expression.getRight().accept(MyInterpreter.visitorSelector);

        while(!(left instanceof Integer || left instanceof  Double)) {
            if(left instanceof Statement)
                left = ((Statement)left).accept(MyInterpreter.visitorSelector);
            else if (left instanceof Expression)
                left = ((Expression)left).accept(MyInterpreter.visitorSelector);
        }
        while(!(right instanceof Integer || right instanceof  Double)) {
            if(right instanceof Statement)
                right = ((Statement)right).accept(MyInterpreter.visitorSelector);
            else if (right instanceof Expression)
                right = ((Expression)right).accept(MyInterpreter.visitorSelector);
            if (right == null)
                return left;
        }
        expression.setLeftType(left.getClass().getSimpleName());
        expression.setRightType(right.getClass().getSimpleName());


        if (expression.getLeftType().equals("Integer") || expression.getRightType().equals("Integer"))
            return new IntConst((Integer) left - (Integer) right).getConstInt();
        else
            return new DoubleConst((Double) left - (Double) right).getDoubleConst();
    }

    @Override
    public Object visit(TimesExpression expression) {
        Object left = expression.getLeft().accept(MyInterpreter.visitorSelector);
        Object right = expression.getRight().accept(MyInterpreter.visitorSelector);

        while(!(left instanceof Integer || left instanceof  Double)) {
            if(left instanceof Statement)
                left = ((Statement)left).accept(MyInterpreter.visitorSelector);
            else if (left instanceof Expression)
                left = ((Expression)left).accept(MyInterpreter.visitorSelector);
        }
        while(!(right instanceof Integer || right instanceof  Double)) {
            if(right instanceof Statement)
                right = ((Statement)right).accept(MyInterpreter.visitorSelector);
            else if (right instanceof Expression)
                right = ((Expression)right).accept(MyInterpreter.visitorSelector);
            if (right == null)
                return left;
        }

        if (left instanceof Integer || right instanceof Integer)
            return new IntConst((Integer) left * (Integer) right).getConstInt();
        else {
            return new DoubleConst((Double) left * (Double) right).getDoubleConst();
        }
    }

    @Override
    public Object visit(DivideExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        while(!(left instanceof Integer || left instanceof  Double)) {
            if(left instanceof Statement)
                left = ((Statement)left).accept(MyInterpreter.visitorSelector);
            else if (left instanceof Expression)
                left = ((Expression)left).accept(MyInterpreter.visitorSelector);
        }
        while(!(right instanceof Integer || right instanceof  Double)) {
            if(right instanceof Statement)
                right = ((Statement)right).accept(MyInterpreter.visitorSelector);
            else if (right instanceof Expression)
                right = ((Expression)right).accept(MyInterpreter.visitorSelector);
            if (right == null)
                return left;
        }

        if (left instanceof Integer || right instanceof Integer)
            return new IntConst((Integer) left / (Integer) right).getConstInt();
        else {
            return new DoubleConst((Double) left / (Double) right).getDoubleConst();
        }
    }

    @Override
    public Expression visit(ExponentialExpression e) {
        Expression value = (Expression) e.getValue().accept(this);
        Expression power = (Expression) e.getPower().accept(this);
        return value;
    }
}
