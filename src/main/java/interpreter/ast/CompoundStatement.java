package interpreter.ast;

import interpreter.visitor.AbstractVisitor;
import interpreter.visitor.EvalVisitor;
import interpreter.ast.statement.Statement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CompoundStatement implements Statement {

    private Statement statement;
    private Statement compoundStatement;

@Override
    public Object accept(AbstractVisitor v) {
        return v.visit(this);
    }}
