package interpreter;

import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.visitor.VisitorVisitor;
import javacc.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class MyInterpreter {

    private static Logger log = LoggerFactory.getLogger(MyInterpreter.class);

    public static void main(String[] args) {
        try {

            File initialFile = new File("program.hc");
            InputStream targetStream = new FileInputStream(initialFile);

            VisitorVisitor visitor = new VisitorVisitor();
            new Parser(targetStream);
            List<AbstractGlobalScopeUnit> abstractGlobalScopeUnits = Parser.start();

            for (AbstractGlobalScopeUnit abstractGlobalScopeUnit : abstractGlobalScopeUnits) {
                visitor.visit(abstractGlobalScopeUnit);
            }

        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}

