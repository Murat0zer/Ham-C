package interpreter.ast.statement;

import interpreter.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SwitchStatement extends Statement {

    private Statement switchStatement;

    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
