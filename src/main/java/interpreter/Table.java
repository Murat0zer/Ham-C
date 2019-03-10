package interpreter;

import lombok.Getter;

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
        structDefinitionsTable[fp].put(structId, structVariables);
    }

    public Map<String, Object> getStructDefinition(String structId) {
        return ((Map<String, Object>)structDefinitionsTable[fp].get(structId));
    }

    public void assignStruct(String structId, Map<String, Object> structVariables) {
        ((Map<String, Object>)structDefinitionsTable[fp].get(structId)).putAll(structVariables);
    }

    public Object getStructVariable(String structId, String variableId) {
        return ((Map<String, Object>)structInstancesTable[fp].get(structId)).get(variableId);
    }

    public void setStructVariable(String structId, String variableId, Object value) {
        ((Map<String, Object>)structInstancesTable[fp].get(structId)).put(variableId, value);
    }

}
