package interpreter;

import interpreter.ast.CompoundStatement;
import interpreter.ast.LabelBlock;
import interpreter.ast.expression.*;
import interpreter.ast.expression.constant.ConstantExpression;
import interpreter.ast.expression.constant.DoubleConst;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.globalscope.FunctionDeclaration;
import interpreter.ast.globalscope.GlobalVariableDeclaration;
import interpreter.ast.globalscope.SimpleInitializer;
import interpreter.ast.globalscope.struct.StructDeclaration;
import interpreter.ast.globalscope.struct.StructInitializer;
import interpreter.ast.globalscope.struct.StructMemberDeclaration;
import interpreter.ast.statement.*;
import interpreter.ast.statement.iteration.DoWhileStatement;
import interpreter.ast.statement.iteration.ForStatement;
import interpreter.ast.statement.iteration.IterationStatement;
import interpreter.ast.statement.iteration.WhileStatement;

public interface Visitor {

    Object visit(Print s);

    Object visit(IntConst exp);

    Object visit(StrConst exp);

    Object visit(DoubleConst exp);

    void visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit);

    void visit(GlobalVariableDeclaration globalVariableDeclaration);

    void visit(StructDeclaration structDeclaration);

    void visit(StructMemberDeclaration structMemberDeclaration);

    void visit(FunctionDeclaration functionDeclaration);

    void visit (StructInitializer structInitializer);

    Object visit (SimpleInitializer simpleInitializer);

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

    Object visit(IdExpression idExpression);

    Object visit(VariableDeclarationStatement statement);

    Object visit(ContinueStatement statement);

    Object visit(BreakStatement statement);

    Object visit(ExpressionOrAssignmentStatement statement);

    Object visit(IfStatement statement);

    Object visit(LabelStatement statement);

    Object visit(ReturnStatement statement);

    Object visit(StatementList statement);

    Object visit(SwitchBlock statement);

    Object visit(SwitchStatement statement);

    Object visit(CompoundStatement statement);

    Object visit(LabelBlock statement);

    Object visit(IterationStatement statement);

    Object visit(WhileStatement statement);

    Object visit(DoWhileStatement statement);

    Object visit(ForStatement statement);





}