package interpreter.ast.statement;

import interpreter.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwitchBlock extends Statement {

    private Statement labelBlock;
    private Statement switchBlock;

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
