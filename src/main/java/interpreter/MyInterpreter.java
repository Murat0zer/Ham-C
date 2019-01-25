package interpreter;

import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import javacc.Parser;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Slf4j
public class MyInterpreter {
    public static void main(String[] args) {
        try {

            Runtime.getRuntime().exec("/home/murat/Desktop/Derleyici/javacc-3.2/javacc-5.0/bin/javacc asdasd");

            File initialFile = new File("program.hc");
            InputStream targetStream = new FileInputStream(initialFile);

            AbstractGlobalScopeUnit abstractGlobalScopeUnit = new Parser(targetStream).start();

            new EvalVisitor().visit(abstractGlobalScopeUnit);

        } catch (Exception exception) {
            log.error(exception.getMessage());
        }
    }
}

