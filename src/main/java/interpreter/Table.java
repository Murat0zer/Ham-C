package interpreter;

import java.util.*;

@SuppressWarnings("unchecked")
public class Table {
    int fp = -1;
    int size;
    Hashtable[] table;
    Hashtable[] structDeclarationsTable;
    Hashtable[] structInstancesTable;

    public Table(int s) {
        size = s;
        table = new Hashtable[s];
        structDeclarationsTable = new Hashtable[s];
        structInstancesTable = new Hashtable[s];

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

    public void addStructDeclaration(String structId, Map<String, Object> structVariables) {
        structDeclarationsTable[fp].put(structId, structVariables);
    }

    public Map<String, Object> getStructDeclaration(String structId) {
        return ((Map<String, Object>) structDeclarationsTable[fp].get(structId));
    }

    public void assignStruct(String structInstanceId, Map<String, Object> structVariables) {
        structDeclarationsTable[fp].put(structInstanceId, structVariables);
    }

    public Object getStructVariable(String structId, String variableId) {
        return ((Map<String, Object>)structInstancesTable[fp].get(structId)).get(variableId);
    }

    public void setStructVariable(String structInstanceId, String variableId, Object value) {
        ((Map<String, Object>)structInstancesTable[fp].get(structInstanceId)).put(variableId, value);
    }

}
