import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Avraham sikirov 318731478
 * Var class implements Expression. represents a string.
 */

public class Var implements Expression {
    private String var;
    private String sign = "Var";

    /**
     * Constructor.
     *
     * @param varIn var string.
     */

    public Var(String varIn) {
        this.var = varIn;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        if (assignment.get(this.var.toString()) != null) {
            return assignment.get(this.var.toString());
        }
        System.out.println("Eror is evalueate in Var");
        return null;
    }

    @Override
    public String getSign() {
        return this.sign;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return true;
    }

    @Override
    public List<String> getVariables() {
        List<String> temp = new LinkedList<>();
        temp.add(this.var);
        return temp;
    }

    @Override
    public String toString() {
        return var;
    }

    @Override
    public Expression assign(String varIn, Expression expression) {
        if (this.var.equals(varIn)) {
            return expression;
        }
        return this;
    }

    @Override
    public void assignHelp(String varIn, Expression expression) {
    }

    @Override
    public Expression getExp1() {
        return null;
    }

    @Override
    public Expression getExp2() {
        return null;
    }

    @Override
    public void setExp1(Expression exp1) {
    }

    @Override
    public void setExp2(Expression exp2) {
    }

    @Override
    public void addToSet(Set set) {
    }

    @Override
    public Expression createExpresion(Expression expression) {
        return new Var(this.toString());
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }

    @Override
    public Expression simplify() {
        return this;
    }

    @Override
    public Boolean getValue() {
        return null;
    }

    @Override
    public Expression simplifyHelp() {
        return this;
    }
}