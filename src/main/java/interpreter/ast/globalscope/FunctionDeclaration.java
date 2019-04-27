package interpreter.ast.globalscope;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.statement.Statement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FunctionDeclaration implements AbstractGlobalScopeUnit {

    private String id;
    private java.util.List parameterList;
    private Statement statementList;
    private String returnType;

    public FunctionDeclaration(String returnType, String id, java.util.List parameterList, Statement statementList) {
        this.id = id;
        this.parameterList = parameterList;
        this.statementList = statementList;
        this.returnType = returnType;
    }

    @Override
    public Object accept(AbstractVisitor v) {
       return v.visit(this);
    }
}
