package interpreter;

import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import javacc.Parser;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MyInterpreter {

    private static Logger log = LoggerFactory.getLogger(MyInterpreter.class);

    public static void main(String[] args) {
        try {

            File initialFile = new File("program.hc");
            InputStream targetStream = new FileInputStream(initialFile);

            EvalVisitor evalVisitor = new EvalVisitor();
            new Parser(targetStream);
            List<AbstractGlobalScopeUnit> abstractGlobalScopeUnits = Parser.start();

            for (AbstractGlobalScopeUnit abstractGlobalScopeUnit : abstractGlobalScopeUnits) {
                evalVisitor.visit(abstractGlobalScopeUnit);
            }

        } catch (Exception exception) {
            log.error(exception.getMessage());
            log.error(exception.getCause().getMessage());
        }
    }
}

