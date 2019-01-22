package interpreter;

import java.util.Hashtable;


public class MyInterpreter {
    public static void main(String[] args) {
        try {
            AbstractGlobalScopeUnit abstractGlobalScopeUnit = new Parser(System.in).start();
            new EvalVisitor().visit(abstractGlobalScopeUnit);

        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        }
    }
}

class Table {
    int fp = -1;
    int size;
    Hashtable[] table;

    public Table(int s) {
        size = s;
        table = new Hashtable[s];
    }

    public void beginScope() {
        table[++fp] = new Hashtable();
    }

    public void endScope() {
        table[fp--] = null;
    }

    public void add(String id, Integer val) {
        table[fp].put(id, val);
    }

    public Integer get(String id) {
        return (Integer) (table[fp].get(id));
    }
}
