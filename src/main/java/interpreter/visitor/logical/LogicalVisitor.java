package interpreter.visitor.logical;

import interpreter.ast.expression.logical.BoolExpression;
import interpreter.ast.expression.logical.LogicalAND;
import interpreter.ast.expression.logical.LogicalOR;
import interpreter.ast.expression.logical.equality.EqualExpression;
import interpreter.ast.expression.logical.equality.NotEqualExpression;
import interpreter.ast.expression.logical.relational.*;
import interpreter.visitor.AbstractVisitor;

public interface LogicalVisitor extends AbstractVisitor {

    @Override
    Object visit(LogicalUnit logicalUnit);

    Object visit(LogicalOR logicalORExp);

    Object visit(LogicalAND logicalANDExp);

    Object visit(EqualExpression equalExpression);

    Object visit(NotEqualExpression expression);

    Object visit(LessThanExpression expression);

    Object visit(LessEqualExpression expression);

    Object visit(GreaterThanExpression expression);

    Object visit(GreaterEqualExpression expression);

    Object visit(BoolExpression boolExpression);

    Object visit(RelationalExpression relationalExpression);


}
