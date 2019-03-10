package interpreter.ast.statement;

import interpreter.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContinueStatement extends Statement {

    public Object accept(Visitor v) {

        v.visit(this);
        return null;
    }
}
