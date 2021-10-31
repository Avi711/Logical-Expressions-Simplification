/**
 * @author Avraham sikirov 318731478.
 * Class represents Base expression, implementing all of the interface
 */

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.LinkedList;

/**
 * Constructor.
 */
public abstract class BaseExpression implements Expression {
    private Expression exp1;
    private Expression exp2;
    private String sign;

    /**
     * @param exp1In first expression.
     * @param exp2In second expression.
     */

    public BaseExpression(Expression exp1In, Expression exp2In) {
        this.exp1 = exp1In;
        this.exp2 = exp2In;
    }

    /**
     * Constructor.
     *
     * @param exp1In expression.
     */
    public BaseExpression(Expression exp1In) {
        this.exp1 = exp1In;
        this.exp2 = null;
    }

    /**
     * @param signIn sign to change to.
     */
    public void setSign(String signIn) {
        this.sign = signIn;
    }

    @Override
    public void setExp1(Expression exp1In) {
        this.exp1 = exp1In;
    }

    @Override
    public void setExp2(Expression exp2In) {
        this.exp2 = exp2In;
    }

    @Override
    public Expression getExp1() {
        return this.exp1;
    }

    @Override
    public Expression getExp2() {
        if (this.exp2 != null) {
            return this.exp2;
        }
        return null;
    }

    @Override
    public String getSign() {
        return this.sign;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        Boolean value1 = null;
        Boolean value2 = null;
        // assign value1 in case of var.
        if (exp1.getSign().equals("Var")) {
            value1 = assignment.get(exp1.toString());
        }
        // Assign value1 in case of val.
        if (exp1.getSign().equals("Val")) {
            value1 = this.exp1.getValue();
        }
        // Assign value2 in case of var.
        if (this.exp2 != null && exp2.getSign().equals("Var")) {
            value2 = assignment.get(exp2.toString());
        }
        // Assign value1 in case of val.
        if (this.exp2 != null && exp2.getSign().equals("Val")) {
            value2 = this.exp2.getValue();
        }
        // Calculate the value if both values exists.
        if (value1 != null && value2 != null) {
            return Factory.getValue(value1, value2, this);
        }
        // Recursion to exp1.
        value1 = this.exp1.evaluate(assignment);
        // Recursion to exp2.
        if (this.exp2 != null) {
            value2 = this.exp2.evaluate(assignment);
        }
        try {
            return Factory.getValue(value1, value2, this);
        } catch (Exception e) {
            System.out.println("Var not found");
        }
        return null;
    }

    @Override
    public Boolean evaluate() throws Exception {
        Map<String, Boolean> assignment = new TreeMap<String, Boolean>();
        return this.evaluate(assignment);
    }

    @Override
    public List<String> getVariables() {
        Set<String> temp = new HashSet<String>();
        addToSet(temp);
        // converting the set to link list and returns it.
        return new LinkedList<String>(temp);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addToSet(Set set) {
        if (exp1.getSign().equals("Var")) {
            set.add(exp1.toString());
        }
        exp1.addToSet(set);

        if (exp2 != null) {
            if (exp2.getSign().equals("Var")) {
                set.add(exp2.toString());
            }
            exp2.addToSet(set);
        }
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression temp = createExpresion(this);
        Expression tempExp = expression.createExpresion(expression);
        temp.assignHelp(var, tempExp);
        return temp;
    }

    @Override
    public void assignHelp(String var, Expression expression) {
        // recursion to exp1.
        if (!(exp1.getSign().equals("Var")) && !(exp1.getSign().equals("Val"))) {
            exp1.assignHelp(var, expression);
        }
        // recursion to exp1.
        if (this.exp2 != null && !(exp2.getSign().equals("Var")) && !(exp2.getSign().equals("Val"))) {
            exp2.assignHelp(var, expression);
        }
        //setting exp1.
        if (this.exp1.toString().equals(var) && !(exp1.getSign().equals("Val"))) {
            this.setExp1(expression);
        }
        //setting exp2.
        if (this.exp2 != null && this.exp2.toString().equals(var) && !(exp2.getSign().equals("Val"))) {
            this.setExp2(expression);
        }
    }

    @Override
    public Expression createExpresion(Expression expression) {
        Expression tempExp2 = null;
        if (expression.getSign().equals("Var")) {
            return new Var(expression.toString());
        }
        if (expression.getSign().equals("Val")) {
            return new Val(expression.getValue());
        }
        // recursion to exp1.
        Expression tempExp1 = createExpresion(expression.getExp1());
        // recursion to exp2.
        if (expression.getExp2() != null) {
            tempExp2 = createExpresion(expression.getExp2());
        }
        return Factory.getInstance(tempExp1, tempExp2, expression);
    }

    @Override
    public String toString() {
        if (sign.equals("~")) {
            // if (exp1.toString().indexOf("(") == 0) {
            //      return sign + exp1;
            //  }
            return sign + "(" + exp1 + ")";
        }
        return "(" + exp1 + sign + exp2 + ")";
    }


    @Override
    public Expression nandify() {
        Expression temp1 = exp1;
        Expression temp2 = exp2;
        // recursion to exp1.
        if (!(exp1.getSign().equals("Var")) && !(exp1.getSign().equals("Val"))) {
            temp1 = this.exp1.nandify();
        }
        // recursion to exp2.
        if (this.exp2 != null && !(exp2.getSign().equals("Var")) && !(exp2.getSign().equals("Val"))) {
            temp2 = this.exp2.nandify();
        }
        return Factory.getNand(temp1, temp2, this);
    }

    @Override
    public Expression norify() {
        Expression temp1 = exp1;
        Expression temp2 = exp2;
        // recursion to exp1.
        if (!(exp1.getSign().equals("Var")) && !(exp1.getSign().equals("Val"))) {
            temp1 = this.exp1.norify();
        }
        // recursion to exp2.
        if (this.exp2 != null && !(exp2.getSign().equals("Var")) && !(exp2.getSign().equals("Val"))) {
            temp2 = this.exp2.norify();
        }
        return Factory.getNor(temp1, temp2, this);
    }

    @Override
    public Expression simplify() {
        Expression temp = this.simplifyHelp();
        // checks if the expression could be simplified further.
        if (temp.toString().equals(temp.simplifyHelp().toString())) {
            return temp;
        }
        return temp.simplify();
    }

    @Override
    public Expression simplifyHelp() {
        Expression temp1 = exp1;
        Expression temp2 = exp2;
        // recursion to exp1.
        if (!(exp1.getSign().equals("Var")) && !(exp1.getSign().equals("Val"))) {
            temp1 = this.exp1.simplifyHelp();
        }
        // recursion to exp2.
        if (this.exp2 != null && !(exp2.getSign().equals("Var")) && !(exp2.getSign().equals("Val"))) {
            temp2 = this.exp2.simplifyHelp();
        }
        return Factory.simplify(temp1, temp2, this);
    }

    @Override
    public Boolean getValue() {
        return null;
    }
}