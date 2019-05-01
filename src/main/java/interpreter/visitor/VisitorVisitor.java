package interpreter.visitor;

import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.visitor._switch.SwitchUnit;
import interpreter.visitor.arithmetic.ArithmeticUnit;
import interpreter.visitor.constant.ConstantUnit;
import interpreter.visitor.flow_control.FlowControlUnit;
import interpreter.visitor.function.FunctionCallUnit;
import interpreter.visitor.function.FunctionDefinitionUnit;
import interpreter.visitor.iteration.IterationUnit;
import interpreter.visitor.logical.LogicalUnit;
import interpreter.visitor.struct.GlobalStructUnit;
import interpreter.visitor.struct.StructStatement;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class VisitorVisitor implements AbstractVisitor {


    @Override
    public Object visit(SwitchUnit switchUnit) {
        return Visitors.switchVisitor.visit(switchUnit);
    }

    @Override
    public Object visit(FunctionDefinitionUnit functionDefinitionUnit) {
        return Visitors.functionVisitor.visit(functionDefinitionUnit);
    }

    @Override
    public Object visit(FunctionCallUnit functionCallUnit) {
        return Visitors.functionVisitor.visit(functionCallUnit);
    }


    @Override
    public Object visit(GlobalStructUnit globalStructUnit) {
        return Visitors.structVisitor.visit(globalStructUnit);

    }

    @Override
    public Object visit(StructStatement structStatement) {
        return Visitors.structVisitor.visit(structStatement);
    }

    @Override
    public Object visit(IterationUnit iterationUnit) {
        return Visitors.iterationVisitor.visit(iterationUnit);
    }

    @Override
    public Object visit(FlowControlUnit flowControlUnit) {
        return Visitors.flowControlVisitor.visit(flowControlUnit);
    }

    @Override
    public Object visit(LogicalUnit logicalUnit) {
        return Visitors.logicalVisitor.visit(logicalUnit);
    }

    @Override
    public Object visit(ArithmeticUnit arithmeticUnit) {
        return Visitors.arithmeticVisitor.visit(arithmeticUnit);
    }

    @Override
    public Object visit(ConstantUnit constantUnit) {
        return Visitors.constantVisitor.visit(constantUnit);
    }

    @Override
    public Object visit(StatementUnit statementUnit) {
        return Visitors.evalVisitor.visit(statementUnit);
    }

    @Override
    public Object visit(ExpressionUnit expressionUnit) {
        return Visitors.evalVisitor.visit(expressionUnit);
    }

    @Override
    public Object visit(GlobalUnit globalUnit) {
        return Visitors.evalVisitor.visit(globalUnit);
    }

    @Override
    public Object visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) {
        return abstractGlobalScopeUnit.accept(this);
    }

}
