package interpreter.ast.expression.arithmetic.multiplicative;

import interpreter.ast.expression.Expression;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.arithmetic.ArithmeticUnit;
import interpreter.visitor.arithmetic.ArithmeticVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DivideExpression implements ArithmeticUnit {

    private Expression left;
    private Expression right;


    @Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }

    @Override
    public Object accept(ArithmeticVisitor arithmeticVisitor) {
       return arithmeticVisitor.visit(this);
    }
}
