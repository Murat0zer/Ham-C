package interpreter.visitor;

import interpreter.visitor._switch.SwitchVisitor;
import interpreter.visitor._switch.SwitchVisitorImpl;
import interpreter.visitor.arithmetic.ArithmeticVisitor;
import interpreter.visitor.arithmetic.ArithmeticVisitorImpl;
import interpreter.visitor.constant.ConstantVisitor;
import interpreter.visitor.constant.ConstantVisitorImpl;
import interpreter.visitor.flow_control.FlowControlVisitor;
import interpreter.visitor.flow_control.FlowControlVisitorImpl;
import interpreter.visitor.function.FunctionVisitor;
import interpreter.visitor.function.FunctionVisitorImpl;
import interpreter.visitor.iteration.IterationVisitor;
import interpreter.visitor.iteration.IterationVisitorImpl;
import interpreter.visitor.logical.LogicalVisitor;
import interpreter.visitor.logical.LogicalVisitorImpl;
import interpreter.visitor.struct.StructVisitor;
import interpreter.visitor.struct.StructVisitorImpl;

public abstract class Visitors {

    private Visitors() {}

    public static final EvalVisitor evalVisitor = new EvalVisitor();

    public static final StructVisitor structVisitor = new StructVisitorImpl();

    public static final SwitchVisitor switchVisitor = new SwitchVisitorImpl();

    public static final FunctionVisitor functionVisitor  = new FunctionVisitorImpl();

    public static final IterationVisitor iterationVisitor = new IterationVisitorImpl();

    public static final FlowControlVisitor flowControlVisitor = new FlowControlVisitorImpl();

    public static final LogicalVisitor logicalVisitor = new LogicalVisitorImpl();

    public static final ArithmeticVisitor arithmeticVisitor = new ArithmeticVisitorImpl();

    public static final ConstantVisitor constantVisitor = new ConstantVisitorImpl();

}

