package interpreter;

import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import javacc.Parser;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class MyInterpreter {
    public static void main(String[] args) {
        try {

            File initialFile = new File("program.hc");
            InputStream targetStream = new FileInputStream(initialFile);

            EvalVisitor evalVisitor = new EvalVisitor();
             List<AbstractGlobalScopeUnit> abstractGlobalScopeUnits =   new Parser(targetStream).start();

             abstractGlobalScopeUnits.forEach(evalVisitor::visit);

        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }
}

