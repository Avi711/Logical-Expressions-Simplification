/**
 * @author Avraham sikirov 318731478.
 * Class represents Base expression, extends base expression.
 */
public abstract class BinaryExpression extends BaseExpression {

    /**
     * Constructor.
     *
     * @param exp1 expression one
     * @param exp2 expresion two
     */

    public BinaryExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }
}