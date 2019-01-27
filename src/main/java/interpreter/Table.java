package interpreter;

import java.util.Hashtable;

public class Table {
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

    public void add(String id, Object val) {
        table[fp].put(id, val);
    }

    public Object get(String id) {
        return (table[fp].get(id));
    }
}
