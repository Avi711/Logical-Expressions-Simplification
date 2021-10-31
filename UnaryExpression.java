/**
 * @author Avraham sikirov 318731478.
 * Class represents Base expression, extends base expression.
 */
public abstract class UnaryExpression extends BaseExpression {

    /**
     * Constructor.
     *
     * @param exp1 expression one
     */

    public UnaryExpression(Expression exp1) {
        super(exp1);
    }
}