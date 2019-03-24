package interpreter;

import interpreter.ast.CompoundStatement;
import interpreter.ast.LabelBlock;
import interpreter.ast.expression.*;
import interpreter.ast.expression.additive.AdditiveExpression;
import interpreter.ast.expression.additive.MinusExpression;
import interpreter.ast.expression.additive.PlusExpression;
import interpreter.ast.expression.constant.ConstantExpression;
import interpreter.ast.expression.constant.DoubleConst;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;
import interpreter.ast.expression.equality.EqualExpression;
import interpreter.ast.expression.equality.NotEqualExpression;
import interpreter.ast.expression.multiplicative.DivideExpression;
import interpreter.ast.expression.multiplicative.TimesExpression;
import interpreter.ast.expression.relational.GreaterEqualExpression;
import interpreter.ast.expression.relational.GreaterThanExpression;
import interpreter.ast.expression.relational.LessEqualExpression;
import interpreter.ast.expression.relational.LessThanExpression;
import interpreter.ast.globalscope.AbstractGlobalScopeUnit;
import interpreter.ast.globalscope.FunctionDeclaration;
import interpreter.ast.globalscope.GlobalVariableDeclaration;
import interpreter.ast.globalscope.SimpleInitializer;
import interpreter.ast.globalscope.struct.*;
import interpreter.ast.statement.*;
import interpreter.ast.statement.iteration.DoWhileStatement;
import interpreter.ast.statement.iteration.ForStatement;
import interpreter.ast.statement.iteration.IterationStatement;
import interpreter.ast.statement.iteration.WhileStatement;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Objects;

@Slf4j
class EvalVisitor implements Visitor {

    boolean brk = false;
    boolean cnt = false;
    Table table = new Table(1000);
    Util util = new Util();


    public void visit(AbstractGlobalScopeUnit abstractGlobalScopeUnit) {
        abstractGlobalScopeUnit.accept(this);

    }

    public void visit(FunctionDeclaration functionDeclaration) {

        table.beginScope();
        functionDeclaration.getStatementList().accept(this);
        table.endScope();

    }

    public void visit(StructMemberDeclaration structMemberDeclaration) {

    }

    public void visit(StructDeclaration structDeclaration) {
        if (table.fp == -1)
            table.beginScope();

        Map<String, Object> structDefaultVariables;
        structDefaultVariables = util.getVariableDeclarationMap(structDeclaration.getStatements(), this);
        String structId = structDeclaration.getStructId();
        table.addStructDeclaration(structId, structDefaultVariables);
    }


    public void visit(GlobalStructDefinition globalStructDefinition) {

        String structId = globalStructDefinition.getStructId();
        String structInstanceId = globalStructDefinition.getStructInstanceId();

        Map<String, Object> newStructVariables;
        newStructVariables = util.getVariableDeclarationMap(globalStructDefinition.getStatements(), this);

        Map<String, Object> defaultStructVariables;
        defaultStructVariables = table.getStructDeclaration(structId);

        Map<String, Object> unassignedDefaultVariables;

        unassignedDefaultVariables = Util.determineUnassignedFor(defaultStructVariables, newStructVariables);
        newStructVariables.putAll(unassignedDefaultVariables);

        table.assignStruct(structInstanceId, newStructVariables);
    }

    @Override
    public Object visit(StructVariableAssignmentStatement structVariableAssignmentStatement) {

        PostfixExpression expression = (PostfixExpression) structVariableAssignmentStatement.getPostfixExpression();
        String structInstanceId = ((IdExpression) expression.getPrimaryExpression()).getId();
        String variableId = expression.getChildId();
        Object value = structVariableAssignmentStatement.getValue().accept(this);

        int tempFp = table.fp;
        Util.setScopeFor(structInstanceId, variableId, table);
        table.setStructVariable(structInstanceId, variableId, value);
        table.fp = tempFp;

        return null;
    }

    @Override
    public void visit(GlobalStructAssignment globalStructAssignment) {

        String structInstanceId = globalStructAssignment.getStructInstanceId();

        Map<String, Object> assignedStructValues = util.getVariableDeclarationMap(globalStructAssignment.getStatements(),this);

        Map<String, Object> oldStructValues = table.getStructInstance(structInstanceId);

        Map<String, Object> unassignedValues;


        unassignedValues = Util.determineUnassignedFor(oldStructValues, assignedStructValues);

        int tempFp = table.fp;

        assignedStructValues.putAll(unassignedValues);
        Util.setScopeFor(structInstanceId, table);

        table.assignStruct(structInstanceId, assignedStructValues);
        table.fp = tempFp;
    }

    @Override
    public Object visit(StructAssignmentStatement structAssignmentStatement) {
        GlobalStructAssignment globalStructAssignment = new GlobalStructAssignment();

        globalStructAssignment.setStatements(structAssignmentStatement.getStatements());
        globalStructAssignment.setStructInstanceId(structAssignmentStatement.getStructInstanceId());
        this.visit(globalStructAssignment);

        return null;
    }

    @Override
    public Object visit(StructDefinitionStatement structDefinitionStatement) {

        GlobalStructDefinition globalStructDefinition = new GlobalStructDefinition();

        globalStructDefinition.setStatements(structDefinitionStatement.getStatements());
        globalStructDefinition.setStructId(structDefinitionStatement.getStructId());
        globalStructDefinition.setStructInstanceId(structDefinitionStatement.getStructInstanceId());
        globalStructDefinition.setConstToken(structDefinitionStatement.getConstToken());
        this.visit(globalStructDefinition);
        return null;
    }

    public void visit(StructInitializer structInitializer) {
        ExpressionList expressionList = (ExpressionList) structInitializer.getExpressions();
        expressionList.getE1().accept(this);
        if (expressionList.getE2() != null)
            expressionList.getE2().accept(this);

    }

    public void visit(GlobalVariableDeclaration globalVariableDeclaration) {
        if (table.fp == -1)
            table.beginScope();
        Object expression = globalVariableDeclaration.getValue().accept(this);
        table.add(globalVariableDeclaration.getId(), expression);
    }

    public Object visit(IntConst exp) {
        return exp.getConstInt();
    }

    public Object visit(StrConst exp) {
        exp.setValue(exp.getValue().replace("\"", ""));
        return exp.getValue();
    }

    public Object visit(DoubleConst exp) {
        return exp.getDoubleConst();
    }

    public Object visit(StatementList s) {

        Statement statementList = null;
        Statement statement = (Statement) s.getStatement().accept(this);
        brk = false;
        cnt = false;
        if (Objects.nonNull(s.getStatementList()))
            statementList = (Statement) s.getStatementList().accept(this);

        return new StatementList(statement, statementList);
    }

    public Object visit(Expression e) {
        return e.accept(this);
    }


    public Object visit(Print printStatement) {
        System.out.println(printStatement.getExpression().accept(this));
        return printStatement;
    }


    public Expression visit(LogicalOR e) {

        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        return new BoolExpression(
                ((BoolExpression) left).isBoolValue() || ((BoolExpression) right).isBoolValue());
    }


    public Expression visit(LogicalAND e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);
        return new BoolExpression(
                ((BoolExpression) left).isBoolValue() && ((BoolExpression) right).isBoolValue());
    }

    @Override
    public Object visit(EqualExpression e) {
        Object left = e.getLeft().accept(this);
        Object right = e.getRight().accept(this);

        return left.equals(right);

    }

    @Override
    public Object visit(NotEqualExpression expression) {

        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return (left != right);

    }

    public Expression visit(RelationalExpression e) {
        Expression left = (Expression) e.getLeft().accept(this);
        Expression right = (Expression) e.getRight().accept(this);

        return new RelationalExpression(left, right, e.getOperatorType());
    }

    @Override
    public Object visit(LessThanExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return new BoolExpression(left.toString().compareTo(right.toString()) < 0).isBoolValue();

    }

    @Override
    public Object visit(LessEqualExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return new BoolExpression(left.toString().compareTo(right.toString()) <= 0).isBoolValue();

    }

    @Override
    public Object visit(GreaterThanExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return new BoolExpression(left.toString().compareTo(right.toString()) > 0).isBoolValue();

    }

    @Override
    public Object visit(GreaterEqualExpression expression) {

        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        return new BoolExpression(left.toString().compareTo(right.toString()) >= 0).isBoolValue();

    }

    public Object visit(AdditiveExpression e) {
        Object left = e.getLeft().accept(this);
        Object right = e.getRight().accept(this);

        e.setLeftType(left.getClass().getSimpleName());
        e.setRightType(right.getClass().getSimpleName());

        return null;
    }

    @Override
    public Object visit(PlusExpression expression) {

        expression.superAccept(this);
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        if (expression.getLeftType().equals("String") || expression.getRightType().equals("String")) {
            return new StrConst(((String) left) + right).getValue();
        } else if (expression.getLeftType().equals("Integer") || expression.getRightType().equals(
                "Integer"))
            return new IntConst((Integer) left + (Integer) right).getConstInt();
        else
            return new DoubleConst((Double) left + (Double) right).getDoubleConst();

    }

    @Override
    public Object visit(MinusExpression expression) {

        expression.superAccept(this);
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        if (expression.getLeftType().equals("Integer") || expression.getRightType().equals("Integer"))
            return new IntConst((Integer) left - (Integer) right).getConstInt();
        else
            return new DoubleConst((Double) left - (Double) right).getDoubleConst();
    }

    @Override
    public Object visit(TimesExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        if (left instanceof Integer || right instanceof Integer)
            return new IntConst((Integer) left * (Integer) right).getConstInt();
        else {
            return new DoubleConst((Double) left * (Double) right).getDoubleConst();
        }
    }

    @Override
    public Object visit(DivideExpression expression) {
        Object left = expression.getLeft().accept(this);
        Object right = expression.getRight().accept(this);

        if (left instanceof Integer || right instanceof Integer)
            return new IntConst((Integer) left / (Integer) right).getConstInt();
        else {
            return new DoubleConst((Double) left / (Double) right).getDoubleConst();
        }
    }

    public Expression visit(ExponentialExpression e) {
        Expression value = (Expression) e.getValue().accept(this);
        Expression power = (Expression) e.getPower().accept(this);
        return value;
    }

    public Object visit(UnaryExpression e) {
        return e.getExpression().accept(this);
    }


    public Expression visit(PrimaryExpression e) {
        return (Expression) e.getExp().accept(this);
    }


    public Object visit(ConstantExpression e) {
        return e.getConstantValue().accept(this);
    }

    public Expression visit(PrimaryExpressionPrime e) {
        Expression n1 = (Expression) e.getExp().accept(this);
        return n1;
    }


    public Object visit(ExpressionList e) {
        Object expression = e.getE1().accept(this);

        ExpressionList expressionList;
        if (e.getE2() != null)
            return e.getE2().accept(this);

        return expression;
    }


    public Expression visit(BoolExpression e) {
        return e;
    }


    public Object visit(PostfixExpression expression) {

        Object value = null;
        int fpTemp = table.fp;
        String structInstanceId = ((IdExpression) expression.getPrimaryExpression()).getId();
        String variableId = expression.getChildId();

        Util.setScopeFor(structInstanceId, variableId, table);

        value = table.getStructVariable(structInstanceId, variableId);
        table.fp = fpTemp;
        return value;
    }



    public Object visit(SimpleInitializer simpleInitializer) {
        if (simpleInitializer.getExpression() != null)
            return simpleInitializer.getExpression().accept(this);
        else
            return simpleInitializer.getStructInitializer().getExpressions().accept(this);
    }

    public Object visit(VariableDeclarationStatement statement) {

        this.table.add(statement.getId(), statement.getValueExp().accept(this));
        return statement;

    }

    @Override
    public void visit(ContinueStatement statement) {
        cnt = true;
    }

    @Override
    public void visit(BreakStatement statement) {
        brk = true;
    }

    @Override
    public Object visit(AssignmentStatement statement) {

        Object value = statement.getValueExp().accept(this);
        table.add(statement.getId(), value);

        return null;

    }

    @Override
    public Object visit(ExpressionStatement statement) {
        if (statement.getExpression() != null) {
            statement.getExpression().accept(this);
        }

        return null;
    }

    @Override
    public Object visit(IfStatement statement) {

        Object boolExp = statement.getBoolExpression().accept(this);
        table.beginScope();
        if ((boolean) boolExp) {
            statement.getTrueBlock().accept(this);
        } else if (statement.getElseBlock() != null) {
            statement.getElseBlock().accept(this);
        }
        table.endScope();

        return null;
    }

    @Override
    public Object visit(LabelStatement statement) {

        return statement.getStatementList().accept(this);
    }


    @Override
    public Object visit(SwitchBlock statement) {

        LabelBlock labelBlock = ((LabelBlock) statement.getLabelBlock());
        BoolExpression isDefaultLabel = new BoolExpression(
                Objects.isNull(labelBlock.getLabelExpression()));

        if (isDefaultLabel.isBoolValue())
            SwitchBlock.setDefaultStatement(labelBlock.getLabelStatement());

        // burdan null donerse eşleşen case bulunmamıştır
        // eger default label ise ignore ediyoruz.
        if (!isDefaultLabel.isBoolValue())
            SwitchBlock.setIsCaseFound(
                    new BoolExpression(Objects.nonNull(statement.getLabelBlock().accept(this))));

        // eger null ise. butun switch caseleri denenmis ve istenilen sonuc bulunamamistir.
        boolean hasMoreLabelBlocks;
        hasMoreLabelBlocks = (Objects.nonNull(statement.getSwitchBlock()));


        if (!SwitchBlock.getIsCaseFound().isBoolValue() && hasMoreLabelBlocks) {
            statement.getSwitchBlock().accept(this);
            return null;
        }
        boolean isDefaultCaseExists = Objects.nonNull(SwitchBlock.getDefaultStatement());
        if (!SwitchBlock.getIsCaseFound().isBoolValue() && !hasMoreLabelBlocks && isDefaultCaseExists)
            SwitchBlock.getDefaultStatement().accept(this);
        return null;
    }

    @Override
    public Object visit(SwitchStatement statement) {

        return statement.getSwitchBlock().accept(this);
    }

    @Override
    public Object visit(LabelBlock statement) {

        Object labelExpression = statement.getLabelExpression().accept(this);
        Object switchExpression = statement.getSwitchExpression().accept(this);

        if (labelExpression.equals(switchExpression))
            return statement.getLabelStatement().accept(this);

        return null;
    }

    @Override
    public Object visit(ReturnStatement statement) {
        return null;
    }


    @Override
    public Object visit(CompoundStatement statement) {
        return null;
    }

    public Object visit(IterationStatement statement) {
        return null;
    }

    @Override
    public Object visit(WhileStatement statement) {
        return null;
    }

    @Override
    public Object visit(DoWhileStatement statement) {
        return null;
    }

    @Override
    public Object visit(ForStatement statement) {

        table.beginScope();
        if (statement.getForIndex() != null)
            statement.getForIndex().accept(this);

        while ((boolean) statement.getBoolExpression().accept(this)) {
            statement.getIterationBody().accept(this);
            if (brk) {
                break;
            }
            if (statement.getForIncrement() != null)
                statement.getForIncrement().accept(this);
        }

        table.endScope();
        return null;
    }

    @Override
    public Object visit(IdExpression idExpression) {

       Object value = null;
        int fpTemp = table.fp;
        while (Objects.isNull(value)) {
            value = table.get(idExpression.getId());
            table.fp--;
            if (table.fp == -1) {
                break;
            }
        }
        table.fp = fpTemp;
        return value;
    }
}
