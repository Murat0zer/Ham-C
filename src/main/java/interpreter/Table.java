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

    public void add(String id, Integer val) {
        table[fp].put(id, val);
    }

    public Integer get(String id) {
        return (Integer) (table[fp].get(id));
    }
}
