package interpreter;

import interpreter.ast.expression.*;
import interpreter.ast.expression.constant.ConstantExpression;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;
import interpreter.ast.globalscope.*;
import interpreter.ast.globalscope.struct.StructDeclaration;
import interpreter.ast.globalscope.struct.StructInitializer;
import interpreter.ast.globalscope.struct.StructMemberDeclaration;
import interpreter.ast.statement.Print;
import interpreter.ast.statement.Statement;

public interface Visitor {

    void visit(Statement s);

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

    Object visit(Expression e);

    Object visit(PostfixExpression e);

    Object visit(PrimaryExpressionPrime e);

    Object visit(ExpressionList e);

    Object visit(BoolExpression e);

}