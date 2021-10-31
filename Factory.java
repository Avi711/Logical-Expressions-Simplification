/**
 * @author Avraham sikirov 318731478.
 * Factory class which returns class after build.
 */

public class Factory {

    /**
     * Getting two base var or val and create and expression.
     *
     * @param exp1 First expression.
     * @param exp2 Second expression.
     * @param exp  expression type.
     * @return New expression.
     */
    public static Expression getInstance(Expression exp1, Expression exp2, Expression exp) {

        if (exp.getSign().equals(" & ")) {
            return new And(exp1, exp2);
        }
        if (exp.getSign().equals(" A ")) {
            return new Nand(exp1, exp2);
        }
        if (exp.getSign().equals(" V ")) {
            return new Nor(exp1, exp2);
        }
        if (exp.getSign().equals("~")) {
            return new Not(exp1);
        }
        if (exp.getSign().equals(" | ")) {
            return new Or(exp1, exp2);
        }
        if (exp.getSign().equals(" # ")) {
            return new Xnor(exp1, exp2);
        }
        if (exp.getSign().equals(" ^ ")) {
            return new Xor(exp1, exp2);
        }
        return null;
    }

    /**
     * Getting two base var or val and create and expression using Nand.
     *
     * @param exp1 First expression.
     * @param exp2 Second expression.
     * @param exp  expression type.
     * @return New expression using Nand.
     */

    public static Expression getNand(Expression exp1, Expression exp2, Expression exp) {

        if (exp.getSign().equals(" & ")) {
            return new Nand(new Nand(exp1, exp2), new Nand(exp1, exp2));
        }
        if (exp.getSign().equals(" A ")) {
            return new Nand(exp1, exp2);
        }
        if (exp.getSign().equals(" V ")) {
            return new Nand(new Nand(new Nand(exp1, exp1), new Nand(exp2, exp2)),
                    new Nand(new Nand(exp1, exp1), new Nand(exp2, exp2)));
        }
        if (exp.getSign().equals("~")) {
            return new Nand(exp1, exp1);
        }
        if (exp.getSign().equals(" | ")) {
            return new Nand(new Nand(exp1, exp1), new Nand(exp2, exp2));
        }
        if (exp.getSign().equals(" # ")) {
            return new Nand(new Nand(new Nand(exp1, exp1), new Nand(exp2, exp2)), new Nand(exp1, exp2));
        }
        if (exp.getSign().equals(" ^ ")) {
            return new Nand(new Nand(exp1, new Nand(exp1, exp2)), new Nand(exp2, new Nand(exp1, exp2)));
        }
        return null;
    }

    /**
     * Getting two base var or val and create and expression using Nor.
     *
     * @param exp1 First expression.
     * @param exp2 Second expression.
     * @param exp  expression type.
     * @return New expression using Nor.
     */

    public static Expression getNor(Expression exp1, Expression exp2, Expression exp) {

        if (exp.getSign().equals(" & ")) {
            return new Nor(new Nor(exp1, exp1), new Nor(exp2, exp2));
        }
        if (exp.getSign().equals(" A ")) {
            return new Nor(new Nor(new Nor(exp1, exp1), new Nor(exp2, exp2)),
                    new Nor(new Nor(exp1, exp1), new Nor(exp2, exp2)));
        }
        if (exp.getSign().equals(" V ")) {
            return new Nor(exp1, exp2);
        }
        if (exp.getSign().equals("~")) {
            return new Nor(exp1, exp1);
        }
        if (exp.getSign().equals(" | ")) {
            return new Nor(new Nor(exp1, exp2), new Nor(exp1, exp2));
        }
        if (exp.getSign().equals(" # ")) {
            return new Nor(new Nor(exp1, new Nor(exp1, exp2)), new Nor(exp2, new Nor(exp1, exp2)));
        }
        if (exp.getSign().equals(" ^ ")) {
            return new Nor(new Nor(new Nor(exp1, exp1), new Nor(exp2, exp2)), new Nor(exp1, exp2));
        }
        return null;
    }

    /**
     * getting an expression and simplifies it by the roles.
     *
     * @param exp1 first expression.
     * @param exp2 second expression.
     * @param exp  expression type.
     * @return simplified expression.
     */

    public static Expression simplify(Expression exp1, Expression exp2, Expression exp) {
        if (exp.getSign().equals(" & ")) {
            return simplifyHelp(exp1, exp2, exp, new Val(true), new Val(false));
        }
        if (exp.getSign().equals(" | ")) {
            return simplifyHelp(exp1, exp2, exp, new Val(false), new Val(true));
        }
        if (exp.getSign().equals("~") && exp1.getSign().equals("Val")) {
            return new Val(!(exp1.getValue()));
        }

        if (exp.getSign().equals(" ^ ")) {
            if (exp1.toString().equals(exp2.toString())) {
                return new Val(false);
            }
            if (exp1.toString().equals("T")) {
                return new Not(exp2);
            }
            if (exp2.toString().equals("T")) {
                return new Not(exp1);
            }
            return simplifyHelp(exp1, exp2, exp, new Val(false), new Val(true));
        }
        if (exp.getSign().equals(" A ")) {
            return simplifyHelp2(exp1, exp2, exp, new Val(true), new Val(false));
        }
        if (exp.getSign().equals(" V ")) {
            return simplifyHelp2(exp1, exp2, exp, new Val(false), new Val(true));
        }
        if (exp.getSign().equals(" # ")) {
            if (exp1.getSign().equals("Val") && exp2.getSign().equals("Val")) {
                return new Val(getValue(exp1.getValue(), exp2.getValue(), exp));
            }
            if (exp1.toString().equals(exp2.toString())) {
                return new Val(true);
            }
        }
        return getInstance(exp1, exp2, exp);
    }

    /**
     * Auxiliary function for Simplify designed to handle the case of "And" and "Or".
     *
     * @param exp1 first expression.
     * @param exp2 second expression.
     * @param exp  expression type.
     * @param v1   value type one.
     * @param v2   value type two.
     * @return simplified expression.
     */

    public static Expression simplifyHelp(Expression exp1, Expression exp2, Expression exp, Val v1, Val v2) {

        // Both of expression are val.
        if (exp1.getSign().equals("Val") && exp2.getSign().equals("Val")) {
            return new Val(getValue(exp1.getValue(), exp2.getValue(), exp));
        }
        // one or both of expression are var.

        if (exp1.toString().equals(v1.toString())) {
            return exp2;
        }
        if (exp2.toString().equals(v1.toString())) {
            return exp1;
        }
        if (exp1.toString().equals(v2.toString()) || exp2.toString().equals(v2.toString())) {
            return new Val(v2.getValue());
        }

        if (exp1.toString().equals(exp2.toString())) {
            return exp1;
        }
        return getInstance(exp1, exp2, exp);
    }

    /**
     * Auxiliary function for Simplify designed to handle the case of "Nand" and "Nor".
     *
     * @param exp1 first expression.
     * @param exp2 second expression.
     * @param exp  expression type.
     * @param v1   value type one.
     * @param v2   value type two.
     * @return simplified expression.
     */

    public static Expression simplifyHelp2(Expression exp1, Expression exp2, Expression exp, Val v1, Val v2) {
        // Both of expression are val.

        if (exp1.getSign().equals("Val") && exp2.getSign().equals("Val")) {
            return new Val(getValue(exp1.getValue(), exp2.getValue(), exp));
        }
        // one or both of expression are var.
        if (exp1.toString().equals(v1.toString())) {
            return new Not(exp2);
        }
        if (exp2.toString().equals(v1.toString())) {
            return new Not(exp1);
        }
        if (exp1.toString().equals(v2.toString()) || exp2.toString().equals(v2.toString())) {
            return new Val(v1.getValue());
        }
        if (exp1.toString().equals(exp2.toString())) {
            return new Not(exp1);
        }
        return getInstance(exp1, exp2, exp);
    }

    /**
     * Getting two base boolean and calculate them.
     *
     * @param value1 First bool
     * @param value2 Second bool.
     * @param exp    expression type.
     * @return value of calculated bool.
     */
    public static Boolean getValue(Boolean value1, Boolean value2, Expression exp) {

        if (exp.getSign().equals(" & ")) {
            return Boolean.logicalAnd(value1, value2);
        }
        if (exp.getSign().equals(" A ")) {
            return !Boolean.logicalAnd(value1, value2);
        }
        if (exp.getSign().equals(" V ")) {
            return !Boolean.logicalOr(value1, value2);
        }
        if (exp.getSign().equals("~")) {
            return !value1;
        }
        if (exp.getSign().equals(" | ")) {
            return Boolean.logicalOr(value1, value2);
        }
        if (exp.getSign().equals(" # ")) {
            return !Boolean.logicalXor(value1, value2);
        }
        if (exp.getSign().equals(" ^ ")) {
            return Boolean.logicalXor(value1, value2);
        }
        return null;
    }
}