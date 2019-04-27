package interpreter.visitor.struct;

import interpreter.ast.globalscope.struct.*;
import interpreter.ast.statement.struct.StructAssignmentStatement;
import interpreter.ast.statement.struct.StructDeclarationStatement;
import interpreter.ast.statement.struct.StructDefinitionStatement;
import interpreter.ast.statement.struct.StructVariableAssignmentStatement;
import interpreter.visitor.AbstractVisitor;

public interface StructVisitor extends AbstractVisitor {


    Object visit(StructStatement structStatement);

    Object visit(StructDeclarationStatement structDefinitionStatement);

    Object visit(StructAssignmentStatement structAssignmentStatement);

    Object visit(GlobalStructAssignment globalStructAssignment);

    Object visit(GlobalStructDeclaration globalStructDeclaration);

    Object visit(GlobalStructDefinition globalStructDefinition);

    Object visit(StructMemberDeclaration structMemberDeclaration);

    Object visit(StructVariableAssignmentStatement structVariableAssignmentStatement);

    Object visit(StructDefinitionStatement structDefinitionStatement);

    Object visit(StructInitializer structInitializer);


}
