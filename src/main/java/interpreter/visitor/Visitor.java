package interpreter.visitor;

import interpreter.ast.CompoundStatement;
import interpreter.ast.expression.*;
import interpreter.ast.expression.additive.AdditiveExpression;
import interpreter.ast.expression.additive.MinusExpression;
import interpreter.ast.expression.additive.PlusExpression;
import interpreter.ast.expression.constant.ConstantExpression;
import interpreter.ast.expression.constant.DoubleConst;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;
import interpreter.ast.expression.equality.EqualExpression;
import interpreter.ast.expression.equality.NotEqualExpression;
import interpreter.ast.expression.multiplicative.DivideExpression;
import interpreter.ast.expression.multiplicative.TimesExpression;
import interpreter.ast.expression.relational.GreaterEqualExpression;
import interpreter.ast.expression.relational.GreaterThanExpression;
import interpreter.ast.expression.relational.LessEqualExpression;
import interpreter.ast.expression.relational.LessThanExpression;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.globalscope.FunctionDeclaration;
import interpreter.ast.globalscope.GlobalVariableDeclaration;
import interpreter.ast.globalscope.SimpleInitializer;
import interpreter.ast.globalscope.struct.*;
import interpreter.ast.statement.*;
import interpreter.ast.statement.iteration.DoWhileStatement;
import interpreter.ast.statement.iteration.ForStatement;
import interpreter.ast.statement.iteration.IterationStatement;
import interpreter.ast.statement.iteration.WhileStatement;

public interface Visitor extends AbstractVisitor {

    Object visit(Print s);

    Object visit(IntConst exp);

    Object visit(StrConst exp);

    Object visit(DoubleConst exp);

    Object visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit);

    Object visit(GlobalVariableDeclaration globalVariableDeclaration);

    Object visit(FunctionDeclaration functionDeclaration);

    Object visit (SimpleInitializer simpleInitializer);

    Object visit(LogicalOR e);

    Object visit(LogicalAND e);

    Object visit(EqualExpression e);

    Object visit(NotEqualExpression expression);

    Object visit(LessThanExpression expression);

    Object visit(LessEqualExpression expression);

    Object visit(GreaterThanExpression expression);

    Object visit(GreaterEqualExpression expression);

    Object visit(AdditiveExpression e);

    Object visit(PlusExpression expression);

    Object visit(MinusExpression expression);

    Object visit(TimesExpression expression);

    Object visit(DivideExpression expression);

    Object visit(ExponentialExpression e);

    Object visit(UnaryExpression e);

    Object visit(PrimaryExpression e);

    Object visit(ConstantExpression e);

    Object visit(Expression e);

    Object visit(PostfixExpression e);

    Object visit(PrimaryExpressionPrime e);

    Object visit(ExpressionList e);

    Object visit(BoolExpression e);

    Object visit(IdExpression idExpression);

    Object visit(VariableDeclarationStatement statement);

    Object visit(ContinueStatement statement);

    Object visit(BreakStatement statement);

    Object visit(AssignmentStatement statement);

    Object visit(ExpressionStatement statement);

    Object visit(IfStatement statement);

    Object visit(ReturnStatement statement);

    Object visit(StatementList statement);

    Object visit(CompoundStatement statement);

    Object visit(IterationStatement statement);

    Object visit(WhileStatement statement);

    Object visit(DoWhileStatement statement);

    Object visit(ForStatement statement);

    Object visit (StructInitializer structInitializer);

}
