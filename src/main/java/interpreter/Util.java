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

        Object value = table.getStructInstance(structInstanceId);
        while (Objects.isNull(value)) {
                log.trace("Cannot find struct in this scope. Checking higher scopes...");
                table.fp--;
                if (table.fp == -1) {
                    log.error("Struct does not exist = {}", structInstanceId);
                    break;
                }
            value = table.getStructInstance(structInstanceId);
        }
    }

    public static void setScopeForStructDefinition(String structId, Table table) {
        Object value = table.getStructDefinition(structId);
        while (Objects.isNull(value)) {
            log.trace("Cannot find struct Definition in this scope. Checking higher scopes...");
            table.fp--;
            if (table.fp == -1) {
                log.error("Struct Definition does not exist = {}", structId);
                break;
            }
            value = table.getStructDefinition(structId);
        }
    }

    static Map<String, Object> determineUnChangedStructVariablesFor(Map<String, Object> oldValues, Map<String, Object> newValues) {

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

            Method methodGetValue;
            Method methodGetId;

            String id;
            Expression expression;

            try {
                methodGetValue = variableDeclarationStatement.getClass().getDeclaredMethod("getValueExp");
                methodGetId = variableDeclarationStatement.getClass().getDeclaredMethod("getId");
                expression = (Expression) methodGetValue.invoke(variableDeclarationStatement);
                id = (String) methodGetId.invoke(variableDeclarationStatement);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                log.error(e.getMessage(), e);
                return;
            }
            Object value = expression.accept(visitor);
            variableMap.put(id, value);
        });

        return variableMap;
    }


}
