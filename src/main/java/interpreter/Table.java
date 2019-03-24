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
        structInstancesTable[fp] = new Hashtable();

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
        if(structDeclarationsTable[fp] == null)
            structDeclarationsTable[fp] = new Hashtable();
        structDeclarationsTable[fp].put(structId, structVariables);
    }

    public Map<String, Object> getStructDeclaration(String structId) {
        return ((Map<String, Object>) structDeclarationsTable[0].get(structId));
    }

    public Map<String, Object> getStructInstance(String structInstanceId) {
        return ((Map<String, Object>) structInstancesTable[fp].get(structInstanceId));
    }

    public void assignStruct(String structInstanceId, Map<String, Object> structVariables) {
        structInstancesTable[fp].put(structInstanceId, structVariables);
    }

    public Object getStructVariable(String structInstanceId, String variableId) {
        return ((Map<String, Object>)structInstancesTable[fp].get(structInstanceId)).get(variableId);
    }

    public void setStructVariable(String structInstanceId, String variableId, Object value) {
        ((Map<String, Object>)structInstancesTable[fp].get(structInstanceId)).put(variableId, value);
    }

}
