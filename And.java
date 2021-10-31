/**
 * @author Avraham sikirov 318731478.
 * Class represents And expression.
 */

public class And extends BinaryExpression {
    private String sign = " & ";

    /**
     * Constructor.
     *
     * @param exp1 first expression.
     * @param exp2 second expression.
     */
    public And(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        super.setSign(sign);
    }
}