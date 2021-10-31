import java.util.Map;
import java.util.TreeMap;

/**
 * @author Avraham sikirov 318731478.
 * Test.
 */
public class ExpressionsTest {

    /**
     * Test.
     *
     * @param args args
     * @throws Exception exception
     */

    public static void main(String[] args) throws Exception {

        Expression test = new And(new Or(new Var("x"), new Var("y")), new Or(new Val(true), new Var("z")));
        System.out.println(test);
        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        assignment.put("z", true);
        Boolean value = test.evaluate(assignment);
        System.out.println("The result is: " + value);
        System.out.println(test.nandify());
        System.out.println(test.norify());
        System.out.println(test.simplify());
    }
}
