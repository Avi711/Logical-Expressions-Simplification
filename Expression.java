import java.util.Map;
import java.util.List;
import java.util.Set;

/**
 * @author Avraham sikirov 318731478.
 * Interface represents any expression.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided in the assignment.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment Map which includes information about values for vars.
     * @return the result
     * @throws Exception if the value isn't in the map, will get error.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * @return Sign of the expression.
     */

    String getSign();

    /**
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return the result.
     * @throws Exception if the value isn't in the map, will get error.
     */
    Boolean evaluate() throws Exception;

    /**
     * @return Returns a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * @return a nice string representation of the expression.
     */
    String toString();

    /**
     * @param var        which to change to expression.
     * @param expression expression to assign when find the var.
     * @return a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the current expression).
     */
    Expression assign(String var, Expression expression);


    /**
     * Help, function for the assign. changing the base accordingly.
     *
     * @param var        which to change to expression.
     * @param expression expression to assign when find the var.
     */

    void assignHelp(String var, Expression expression);

    /**
     * adding the all the vars of the expression to set.
     *
     * @param set we want to ad the expression to.
     */


    void addToSet(Set set);

    /**
     * @return exp1
     */

    Expression getExp1();

    /**
     * @return exp2
     */
    Expression getExp2();

    /**
     * @param exp1 expression to change to.
     */

    void setExp1(Expression exp1);

    /**
     * @param exp2 expression to change to.
     */
    void setExp2(Expression exp2);

    /**
     * @param expression expresion to create.
     * @return a new expression created form the base.
     */

    Expression createExpresion(Expression expression);

    /**
     * @return Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     */
    Expression nandify();

    /**
     * @return Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     */
    Expression norify();

    /**
     * @return a simplified version of the current expression.
     */
    Expression simplify();

    /**
     * @return value
     */

    Boolean getValue();

    /**
     * @return Returned a simplified version of the current expression.
     */
    Expression simplifyHelp();
}
