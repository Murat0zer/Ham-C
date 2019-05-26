package interpreter;

import interpreter.ast.expression.Expression;
import interpreter.ast.expression.function.FunctionCall;
import interpreter.visitor.AbstractVisitor;
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
public class Util {

    private Util() {}

    public static int setScopeFor(String structInstanceId, String variableId) {

        Object value = null;
        while (Objects.isNull(value)) {
            try {
                value = Table.getStructVariable(structInstanceId, variableId);
            } catch (NullPointerException e) {
                log.trace("Cannot find variable in this scope. Checking higher scopes...");
                Table.fp--;
                if (Table.fp == -1) {
                    log.error("Variable does not exist = {}", structInstanceId + "." + variableId);
                    break;
                }
            }

        }
        return Table.fp;
    }

    public static void setScopeFor(String structInstanceId) {

        Object value = null;
        while (Objects.isNull(value)) {
            try {
                value = Table.getStructInstance(structInstanceId);
            } catch (Exception e){
                log.trace("Cannot find struct in this scope. Checking higher scopes...");
                Table.fp--;
                if (Table.fp == -1) {
                    log.error("Struct does not exist = {}", structInstanceId);
                    break;
                }
            }
        }
    }

    public static void setScopeForStructDefinition(String structId) {
        Object value = null;
        while (Objects.isNull(value)) {
            try {
                value = Table.getStructDefinition(structId);
            } catch (Exception e) {
                log.trace("Cannot find struct Definition in this scope. Checking higher scopes...");
                Table.fp--;
                if (Table.fp == -1) {
                    log.error("Struct Definition does not exist = {}", structId);
                    break;
                }
            }
        }
    }

    public static Map<String, Object> determineUnChangedStructVariablesFor(Map<String, Object> oldValues, Map<String, Object> newValues) {

        Predicate<Map.Entry<String, Object>> entryPredicate = s -> !(newValues.keySet().contains(s.getKey()));
        return oldValues
                .entrySet()
                .stream()
                .filter(entryPredicate)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }



    public static <T> Map<String, Object> getVariableDeclarationMap(Set<T> statementSet, AbstractVisitor visitor) {

        Map<String, Object> variableMap = new HashMap<>();

        statementSet.forEach(variableDeclarationStatement -> {

            Method getValueMethod;
            Method getIdMethod;

            String id;
            Expression expression;

            try {
                getValueMethod = variableDeclarationStatement.getClass().getDeclaredMethod("getValueExp");
                getIdMethod = variableDeclarationStatement.getClass().getDeclaredMethod("getId");
                expression = (Expression) getValueMethod.invoke(variableDeclarationStatement);
                id = (String) getIdMethod.invoke(variableDeclarationStatement);

            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                log.error(e.getMessage(), e);
                return;
            }
            Object value = expression == null ? null : expression.accept(visitor);
            variableMap.put(id, value);
        });

        return variableMap;
    }


    public static void addFunctionParametersToTable(FunctionCall functionCall) {

    }
}
