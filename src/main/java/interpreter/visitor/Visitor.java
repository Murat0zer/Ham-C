package interpreter.visitor;

import interpreter.ast.CompoundStatement;
import interpreter.ast.expression.*;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.globalscope.GlobalVariableDeclaration;
import interpreter.ast.globalscope.SimpleInitializer;
import interpreter.ast.statement.*;

public interface Visitor extends AbstractVisitor {




    Object visit(Print s);

    Object visit(GlobalVariableDeclaration globalVariableDeclaration);

    Object visit(SimpleInitializer simpleInitializer);


    Object visit(UnaryExpression e);

    Object visit(PrimaryExpression e);

    Object visit(PostfixExpression e);

    Object visit(PrimaryExpressionPrime e);

    Object visit(ExpressionList e);

    Object visit(IdExpression idExpression);

    Object visit(VariableDeclarationStatement statement);

    Object visit(AssignmentStatement statement);

    Object visit(ExpressionStatement statement);

    Object visit(StatementList statement);

    Object visit(CompoundStatement statement);


}
