/**
 * @author Avraham sikirov 318731478.
 * Class represents Nor expression.
 */

public class Nor extends BinaryExpression {

    private String sign = " V ";

    /**
     * Constructor.
     *
     * @param exp1 first expression.
     * @param exp2 second expression.
     */
    public Nor(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        super.setSign(sign);
    }
}
