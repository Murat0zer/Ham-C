package interpreter;

import interpreter.ast.expression.function.FunctionCall;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.visitor.VisitorVisitor;
import interpreter.visitor.function.FunctionVisitorImpl;
import javacc.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;


public class MyInterpreter {

    private static Logger log = LoggerFactory.getLogger(MyInterpreter.class);
    public static final  VisitorVisitor visitorSelector = new VisitorVisitor();

    public static void main(String[] args) {
        try {

            File initialFile = new File("program.hc");
            InputStream targetStream = new FileInputStream(initialFile);

            new Parser(targetStream);
            List<AbstractGlobalScopeUnit> abstractGlobalScopeUnits = Parser.start();

            for (AbstractGlobalScopeUnit abstractGlobalScopeUnit : abstractGlobalScopeUnits) {
                visitorSelector.visit(abstractGlobalScopeUnit);
            }
            FunctionCall functionCall = new FunctionCall();
            functionCall.setFunctionId("main");

            Table.beginScope();
            Table.add("caller_id", "main");
            Table.add("callee_id", "main");
            visitorSelector.visit(functionCall);
            log.info("{} total function call...", FunctionVisitorImpl.functionCallCount);

        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}

