package interpreter.ast.statement;

import interpreter.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BreakStatement extends Statement {

    private Statement statement;

    public Object accept(Visitor v) {
        v.visit(this);
        return null;
    }
}
