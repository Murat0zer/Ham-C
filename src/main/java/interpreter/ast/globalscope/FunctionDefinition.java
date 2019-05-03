package interpreter.ast.globalscope;

import interpreter.ast.statement.Statement;
import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.function.FunctionDefinitionUnit;
import interpreter.visitor.function.FunctionVisitor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FunctionDefinition implements FunctionDefinitionUnit {

    private String returnType;
    private String id;
    private java.util.List parameterList;
    private Statement statementList;


    @Override
    public Object accept(AbstractVisitor v) {
       return v.visit(this);
    }

    @Override
    public Object accept(FunctionVisitor functionVisitor) {
        return functionVisitor.visit(this);
    }
}
