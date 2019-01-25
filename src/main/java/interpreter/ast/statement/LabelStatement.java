package interpreter.ast.statement;

import interpreter.Visitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LabelStatement extends  Statement {

    private Statement statementList;

    public Object accept(Visitor v) {
       return v.visit(this);
    }
}
