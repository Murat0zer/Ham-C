package interpreter.visitor.function;

import interpreter.ast.globalscope.FunctionDefinitionDefinition;
import interpreter.ast.expression.function.FunctionCall;
import interpreter.visitor.AbstractVisitor;

public interface FunctionVisitor extends AbstractVisitor {


    @Override
    Object visit(FunctionDefinitionUnit functionDefinitionUnit);

    @Override
    Object visit(FunctionCallUnit functionCallUnit);

    Object visit(FunctionDefinitionDefinition functionDefinition);

    Object visit(FunctionCall functionCall);



}
