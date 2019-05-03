package interpreter.visitor.function;

import interpreter.MyInterpreter;
import interpreter.Table;
import interpreter.ast.Variable;
import interpreter.ast.expression.Expression;
import interpreter.ast.expression.ExpressionList;
import interpreter.ast.expression.PrimaryExpressionPrime;
import interpreter.ast.expression.function.FunctionCall;
import interpreter.ast.globalscope.FunctionDefinition;
import interpreter.ast.statement.Statement;
import interpreter.visitor.VisitorVisitor;
import javafx.scene.control.Tab;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FunctionVisitorImpl implements FunctionVisitor {

    public static int functionCallCount = 0;
    @Override
    public Object visit(FunctionDefinitionUnit functionDefinitionUnit) {
        return functionDefinitionUnit.accept(this);
    }

    @Override
    public Object visit(FunctionCallUnit functionCallUnit) {
        return functionCallUnit.accept(this);
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition) {

        Table.addFunctionDefinition(functionDefinition);
        return null;
    }

    @Override
    public Object visit(FunctionCall functionCall) {

        FunctionDefinition functionDefinition;
        functionDefinition = (FunctionDefinition) Table.getFunctionDefinition(functionCall.getFunctionId());

        Map<String, Object> functionParameters = new HashMap<>();

        Optional<Expression> opPrimaryExpPrime = Optional.ofNullable(functionCall.getPrimaryExpressionPrime());
        PrimaryExpressionPrime primaryExpressionPrime = (PrimaryExpressionPrime) opPrimaryExpPrime.orElse(null);

        Optional<Expression> opExpList = primaryExpressionPrime != null ?
                Optional.ofNullable(primaryExpressionPrime.getExp()) : Optional.empty();

        ExpressionList expList = (ExpressionList) opExpList.orElse(null);

        List<Variable> variables;
        List<Expression> passedParameters = new ArrayList<>();

        if (expList != null) {
            while (expList.getE1() != null) {

                Expression expression;
                passedParameters.add(expList.getE1());

                Optional<Expression> opExp = Optional.ofNullable(expList.getE2());

                expression = opExp.orElse(null);

                if (expression instanceof ExpressionList)
                    expList = (ExpressionList) expression;
                else if (expression != null) {
                    passedParameters.add(expression);
                    break;
                } else
                    break;

            }
        }

        Optional<List<Variable>> optionalVariables;
        optionalVariables = Optional.ofNullable((List<Variable>) functionDefinition.getParameterList());
        variables = optionalVariables.orElse(null);

        if (variables != null) {
            functionParameters = IntStream.range(0, variables.size())
                    .boxed()
                    .collect(Collectors
                            .toMap(i -> variables.get(i).getId(),
                                    i -> passedParameters.get(i).accept(MyInterpreter.visitorSelector)));

        }

        String uniqueId = UUID.randomUUID().toString();
        if(!functionDefinition.getId().equals("main")) {
            String callerId = Table.get("callee_id").toString();
            Table.beginScope();
            Table.add("caller_id",callerId);
            Table.add("callee_id", uniqueId);
            Table.add("return", false);
            Table.add("break", false);
            Table.add("continue", false);
            functionCallCount++;
        } else {
            Table.add("return", false);
            Table.add("break", false);
            Table.add("continue", false);
        }


        Object returnObject;

        VisitorVisitor visitor = MyInterpreter.visitorSelector;
        functionParameters.forEach(Table::add);

        Statement statementList = functionDefinition.getStatementList();
        returnObject = statementList.accept(visitor);


        Table.endScope();
        return returnObject;
    }
}
