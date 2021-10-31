/**
 * @author Avraham sikirov 318731478.
 * Class represents Not expression.
 */
public class Not extends UnaryExpression {

    private String sign = "~";

    /**
     * Constructor.
     *
     * @param exp1 first expression.
     */
    public Not(Expression exp1) {
        super(exp1);
        super.setSign(sign);
    }
}