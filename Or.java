/**
 * @author Avraham sikirov 318731478.
 * Class represents Or expression.
 */
public class Or extends BinaryExpression {

    private String sign = " | ";

    /**
     * Constructor.
     *
     * @param exp1 first expression.
     * @param exp2 second expression.
     */
    public Or(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        super.setSign(sign);
    }
}