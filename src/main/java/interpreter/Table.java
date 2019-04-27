package interpreter;

import java.util.*;

@SuppressWarnings("unchecked")
public class Table {
    public static int fp = -1;
    static Hashtable[] table = new Hashtable[1000];
    static Hashtable[] structDefinitionsTable = new Hashtable[1000];
    static Hashtable[] structInstancesTable = new Hashtable[1000];


    public static void beginScope() {
        table[++fp] = new Hashtable();
        structInstancesTable[fp] = new Hashtable();

    }

    public static void endScope() {
        table[Table.fp--] = null;
    }

    public static void add(String id, Object val) {
        table[Table.fp].put(id, val);
    }

    public static Object get(String id) {
        return (table[Table.fp].get(id));
    }

    public static void addStructDefinition(String structId, Map<String, Object> structVariables) {
        if(structDefinitionsTable[Table.fp] == null)
            structDefinitionsTable[Table.fp] = new Hashtable();
        structDefinitionsTable[Table.fp].put(structId, structVariables);
    }

    public static Map<String, Object> getStructDefinition(String structId) {
        return ((Map<String, Object>) structDefinitionsTable[Table.fp].get(structId));
    }

    public static Map<String, Object> getStructInstance(String structInstanceId) {
        return ((Map<String, Object>) structInstancesTable[Table.fp].get(structInstanceId));
    }

    public static void assignStruct(String structInstanceId, Map<String, Object> structVariables) {
        structInstancesTable[Table.fp].put(structInstanceId, structVariables);
    }

    public static Object getStructVariable(String structInstanceId, String variableId) {
        return ((Map<String, Object>)structInstancesTable[Table.fp].get(structInstanceId)).get(variableId);
    }

    public static void setStructVariable(String structInstanceId, String variableId, Object value) {
        ((Map<String, Object>)structInstancesTable[Table.fp].get(structInstanceId)).put(variableId, value);
    }

}
