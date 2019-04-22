package interpreter;

import java.util.*;

@SuppressWarnings("unchecked")
public class Table {
    int fp = -1;
    int size;
    Hashtable[] table;
    Hashtable[] structDefinitionsTable;
    Hashtable[] structInstancesTable;

    public Table(int s) {
        size = s;
        table = new Hashtable[s];
        structDefinitionsTable = new Hashtable[s];
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

    public void addStructDefinition(String structId, Map<String, Object> structVariables) {
        if(structDefinitionsTable[fp] == null)
            structDefinitionsTable[fp] = new Hashtable();
        structDefinitionsTable[fp].put(structId, structVariables);
    }

    public Map<String, Object> getStructDefinition(String structId) {
        return ((Map<String, Object>) structDefinitionsTable[fp].get(structId));
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
