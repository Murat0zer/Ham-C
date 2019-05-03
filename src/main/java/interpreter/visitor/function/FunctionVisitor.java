package interpreter.visitor.function;

import interpreter.ast.expression.function.FunctionCall;
import interpreter.ast.globalscope.FunctionDefinition;
import interpreter.visitor.AbstractVisitor;

public interface FunctionVisitor extends AbstractVisitor {


    @Override
    Object visit(FunctionDefinitionUnit functionDefinitionUnit);

    @Override
    Object visit(FunctionCallUnit functionCallUnit);

    Object visit(FunctionDefinition functionDefinition);

    Object visit(FunctionCall functionCall);



}
