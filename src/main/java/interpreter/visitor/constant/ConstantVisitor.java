
package interpreter.visitor.constant;

import interpreter.ast.expression.constant.ConstantExpression;
import interpreter.ast.expression.constant.DoubleConst;
import interpreter.ast.expression.constant.IntConst;
import interpreter.ast.expression.constant.StrConst;
import interpreter.visitor.AbstractVisitor;

public interface ConstantVisitor extends AbstractVisitor {

    @Override
    Object visit(ConstantUnit constantUnit);

    Object visit(IntConst intConst);

    Object visit(StrConst strConst);

    Object visit(DoubleConst doubleConst);

    Object visit(ConstantExpression constantExpression);
}
