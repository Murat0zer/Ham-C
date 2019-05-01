package interpreter.visitor.struct;

import interpreter.Table;
import interpreter.Util;
import interpreter.ast.expression.ExpressionList;
import interpreter.ast.expression.IdExpression;
import interpreter.ast.expression.PostfixExpression;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.globalscope.struct.*;
import interpreter.ast.statement.struct.StructAssignmentStatement;
import interpreter.ast.statement.struct.StructDeclarationStatement;
import interpreter.ast.statement.struct.StructDefinitionStatement;
import interpreter.ast.statement.struct.StructVariableAssignmentStatement;
import interpreter.visitor.VisitorVisitor;

import java.util.Map;

public class StructVisitorImpl  implements StructVisitor  {


    @Override
    public Object visit(GlobalStructUnit globalStructUnit) {
        return globalStructUnit.accept(this);
    }

    @Override
    public Object visit(StructStatement structStatement) {
        return structStatement.accept(this);
    }

    @Override
    public Object visit(StructMemberDeclaration structMemberDeclaration) {
        return null;
    }

    @Override
    public Object visit(GlobalStructDefinition globalStructDefinition) {
        if (Table.fp == -1)
            Table.beginScope();

        Map<String, Object> structDefaultVariables;
        structDefaultVariables = Util.getVariableDeclarationMap(globalStructDefinition.getStatements(), this);
        String structId = globalStructDefinition.getStructId();
        Table.addStructDefinition(structId, structDefaultVariables);
        return null;
    }


    @Override
    public Object visit(GlobalStructDeclaration globalStructDeclaration) {

        String structId = globalStructDeclaration.getStructId();
        String structInstanceId = globalStructDeclaration.getStructInstanceId();

        Map<String, Object> newStructVariables;
        newStructVariables = Util.getVariableDeclarationMap(globalStructDeclaration.getStatements(), new VisitorVisitor());

        Map<String, Object> defaultStructVariables;
        int tempFp = Table.fp;
        Util.setScopeForStructDefinition(structId);
        defaultStructVariables = Table.getStructDefinition(structId);
        Table.fp = tempFp;

        Map<String, Object> unChangedDefaultVariables;

        unChangedDefaultVariables = Util.determineUnChangedStructVariablesFor(defaultStructVariables, newStructVariables);
        newStructVariables.putAll(unChangedDefaultVariables);

        Table.assignStruct(structInstanceId, newStructVariables);
        return null;
    }

    @Override
    public Object visit(StructVariableAssignmentStatement structVariableAssignmentStatement) {

        PostfixExpression expression = (PostfixExpression) structVariableAssignmentStatement.getPostfixExpression();
        String structInstanceId = ((IdExpression) expression.getPrimaryExpression()).getId();
        String variableId = expression.getChildId();
        Object value = structVariableAssignmentStatement.getValue().accept(this);

        int tempFp = Table.fp;
        Util.setScopeFor(structInstanceId, variableId);
        Table.setStructVariable(structInstanceId, variableId, value);
        Table.fp = tempFp;

        return null;
    }

    @Override
    public Object visit(GlobalStructAssignment globalStructAssignment) {

        String structInstanceId = globalStructAssignment.getStructInstanceId();

        int tempFp = Table.fp;
        Util.setScopeFor(structInstanceId);

        Map<String, Object> assignedStructValues = Util.getVariableDeclarationMap(globalStructAssignment.getStatements(),this);

        Map<String, Object> oldStructValues = Table.getStructInstance(structInstanceId);

        Map<String, Object> unchangedStructVariables;

        unchangedStructVariables = Util.determineUnChangedStructVariablesFor(oldStructValues, assignedStructValues);

        assignedStructValues.putAll(unchangedStructVariables);

        Table.assignStruct(structInstanceId, assignedStructValues);
        Table.fp = tempFp;
        return null;
    }

    @Override
    public Object visit(StructAssignmentStatement structAssignmentStatement) {
        GlobalStructAssignment globalStructAssignment = new GlobalStructAssignment();

        globalStructAssignment.setStatements(structAssignmentStatement.getStatements());
        globalStructAssignment.setStructInstanceId(structAssignmentStatement.getStructInstanceId());
        this.visit(globalStructAssignment);

        return null;
    }

    @Override
    public Object visit(StructDeclarationStatement structDeclarationStatement) {

        // TODO: 28.04.2019 global degil local olmasi lazim bunun.
        GlobalStructDeclaration globalStructDeclaration = new GlobalStructDeclaration();

        globalStructDeclaration.setStatements(structDeclarationStatement.getStatements());
        globalStructDeclaration.setStructId(structDeclarationStatement.getStructId());
        globalStructDeclaration.setStructInstanceId(structDeclarationStatement.getStructInstanceId());
        globalStructDeclaration.setConstToken(structDeclarationStatement.getConstToken());
        this.visit(globalStructDeclaration);
        return null;
    }

    @Override
    public Object visit(StructDefinitionStatement structDefinitionStatement) {
        Map<String, Object> structDefaultVariables;
        structDefaultVariables = Util.getVariableDeclarationMap(structDefinitionStatement.getStatements(), this);
        String structId = structDefinitionStatement.getStructId();
        Table.addStructDefinition(structId, structDefaultVariables);
        return null;
    }

    @Override
    public Object visit(StructInitializer structInitializer) {
        ExpressionList expressionList = (ExpressionList) structInitializer.getExpressions();
        expressionList.getE1().accept(this);
        if (expressionList.getE2() != null)
            expressionList.getE2().accept(this);

        return null;
    }
}
