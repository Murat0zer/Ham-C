package interpreter;

import interpreter.ast.expression.Expression;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
class Util {


    static int setScopeFor(String structInstanceId, String variableId, Table table) {

        Object value = null;
        while (Objects.isNull(value)) {
            try {
                value = table.getStructVariable(structInstanceId, variableId);
            } catch (NullPointerException e) {
                log.trace("Cannot find variable in this scope. Checking higher scopes...");
                table.fp--;
                if (table.fp == -1) {
                    log.error("Variable does not exist = {}", structInstanceId + "." + variableId);
                    break;
                }
            }

        }
        return table.fp;
    }

    static void setScopeFor(String structInstanceId, Table table) {

        Object value = null;
        while (Objects.isNull(value)) {
            try {
                value = table.getStructInstance(structInstanceId);
            } catch (NullPointerException e) {
                log.trace("Cannot find struct in this scope. Checking higher scopes...");
                table.fp--;
                if (table.fp == -1) {
                    log.error("Struct does not exist = {}", structInstanceId);
                    break;
                }
            }

        }
    }

    static Map<String, Object> determineUnassignedFor(Map<String, Object> oldValues, Map<String, Object> newValues) {

        Predicate<Map.Entry<String, Object>> entryPredicate = s -> !(newValues.keySet().contains(s.getKey()));
        return oldValues
                .entrySet()
                .stream()
                .filter(entryPredicate)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    <T> Map<String, Object> getVariableDeclarationMap(Set<T> statementSet, Visitor visitor) {

        Map<String, Object> variableMap = new HashMap<>();

        statementSet.forEach(variableDeclarationStatement -> {
            Method methodGetValue = null;
            Method methodGetId = null;
            String id = null;

            Expression expression = null;
            try {
                methodGetValue = variableDeclarationStatement.getClass().getDeclaredMethod("getValueExp");
                methodGetId = variableDeclarationStatement.getClass().getDeclaredMethod("getId");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            try {
                expression = (Expression) methodGetValue.invoke(variableDeclarationStatement);
                id = (String) methodGetId.invoke(variableDeclarationStatement);

            } catch (IllegalAccessException | InvocationTargetException e) {
                log.error(e.getMessage(), e);
            }
            Object value = expression.accept(visitor);
            variableMap.put(id, value);
        });

        return variableMap;
    }


}
