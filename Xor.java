/**
 * @author Avraham sikirov 318731478.
 * Class represents Xor expression.
 */
public class Xor extends BinaryExpression {
    private String sign = " ^ ";

    /**
     * Constructor.
     *
     * @param exp1 first expression.
     * @param exp2 second expression.
     */
    public Xor(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        super.setSign(sign);
    }
}
