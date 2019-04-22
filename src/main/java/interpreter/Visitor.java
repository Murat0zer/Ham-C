package interpreter;

import interpreter.ast.CompoundStatement;
import interpreter.ast.LabelBlock;
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
import interpreter.ast.statement.struct.StructAssignmentStatement;
import interpreter.ast.statement.struct.StructDeclarationStatement;
import interpreter.ast.statement.struct.StructDefinitionStatement;
import interpreter.ast.statement.struct.StructVariableAssignmentStatement;

public interface Visitor {

    Object visit(Print s);

    Object visit(IntConst exp);

    Object visit(StrConst exp);

    Object visit(DoubleConst exp);

    void visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit);

    void visit(GlobalVariableDeclaration globalVariableDeclaration);

    void visit(FunctionDeclaration functionDeclaration);

    void visit (StructInitializer structInitializer);

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

    void visit(ContinueStatement statement);

    void visit(BreakStatement statement);

    Object visit(AssignmentStatement statement);

    Object visit(ExpressionStatement statement);

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

    Object visit(StructDeclarationStatement structDefinitionStatement);

    Object visit(StructAssignmentStatement structAssignmentStatement);

    void visit(GlobalStructAssignment globalStructAssignment);

    void visit(GlobalStructDeclaration globalStructDeclaration);

    void visit(GlobalStructDefinition globalStructDefinition);

    void visit(StructMemberDeclaration structMemberDeclaration);

    Object visit(StructVariableAssignmentStatement structVariableAssignmentStatement);

    Object visit(StructDefinitionStatement structDefinitionStatement);
}
