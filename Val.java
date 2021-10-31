import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Avraham sikirov 318731478.
 * Val class implements Expression. represents a value.
 */

public class Val implements Expression {
    private boolean val;
    private String sign = "Val";

    /**
     * Constructor.
     *
     * @param val value.
     */
    public Val(boolean val) {
        this.val = val;
    }

    @Override
    public Boolean getValue() {
        return this.val;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.val;
    }

    @Override
    public String getSign() {
        return this.sign;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.val;
    }

    @Override
    public List<String> getVariables() {
        return new LinkedList<>();
    }

    @Override
    public String toString() {
        if (this.val) {
            return "T";
        }
        return "F";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }

    @Override
    public void assignHelp(String var, Expression expression) {
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
        return new Val(this.val);
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
    public Expression simplifyHelp() {
        return this;
    }
}