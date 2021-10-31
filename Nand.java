/**
 * @author Avraham sikirov 318731478.
 * Class represents Nand expression.
 */

public class Nand extends BinaryExpression {

    private String sign = " A ";

    /**
     * Constructor.
     *
     * @param exp1 first expression.
     * @param exp2 second expression.
     */
    public Nand(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        super.setSign(sign);
    }
}