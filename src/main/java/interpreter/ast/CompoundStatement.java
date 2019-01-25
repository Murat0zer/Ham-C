package interpreter.ast;

import interpreter.Visitor;
import interpreter.ast.statement.Statement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompoundStatement extends Statement {

    private Statement statement;
    private Statement compoundStatement;

    public Object accept(Visitor v) {
       return v.visit(this);
    }
}
