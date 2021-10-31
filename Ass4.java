
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.util.*;

@SuppressWarnings("unchecked")
public class Ass4 {
    private List<Expression> expressions = new ArrayList<>();
    private List<Map<String, Boolean>> assignments = new ArrayList<>();
    private static List<Integer> integers = new ArrayList<>();
    private static List<Integer> integers1 = new ArrayList<>();
    private static int check = 0;
    Map<String, String> answers;

    public Ass4(String filename) {
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(filename));
            this.answers = (Map<String, String>) o.readObject();
        } catch (Exception e) {
            System.out.println("Reading error");
        }
    }

    public void add_exp() {
        this.expressions.add(new And(new Var("X"), new Var("X")));
        this.expressions.add(new Or(new Var("X"), new Var("X")));
        this.expressions.add(new Xor(new Var("X"), new Var("X")));
        this.expressions.add(new Nand(new Var("X"), new Var("X")));
        this.expressions.add(new Nor(new Var("X"), new Var("X")));
        this.expressions.add(new Xnor(new Var("X"), new Var("X")));
        this.expressions.add(new Not(new Var("X")));

        this.expressions.add(new And(new Var("X"), new Var("Y")));
        this.expressions.add(new Or(new Var("X"), new Var("Y")));
        this.expressions.add(new Xor(new Var("X"), new Var("Y")));
        this.expressions.add(new Nand(new Var("X"), new Var("Y")));
        this.expressions.add(new Nor(new Var("X"), new Var("Y")));
        this.expressions.add(new Xnor(new Var("X"), new Var("Y")));
        this.expressions.add(new Not(new Var("X")));

        this.expressions.add(new And(new Var("X"), new Or(new Var("Y"), new Var("Z"))));
        this.expressions.add(new And(new Var("X"), new Xor(new Var("Y"), new Var("Z"))));
        this.expressions.add(new Or(new Var("X"), new Nand(new Var("Y"), new Var("Z"))));
        this.expressions.add(new Or(new Var("X"), new Nor(new Var("Y"), new Var("Z"))));
        this.expressions.add(new Not(new Xnor(new Var("X"), new Nor(new Var("Y"), new Var("Z")))));
    }

   /* public void add_comp_exp() {
        this.expressions.add(new Not(new Xor(new And(new Val(true), new Or(new Var("X"), new Var("Y"))), new Var("Z"))));

        Expression a = new And(new Var("X"), new Var("Y"));
        Expression b = new Xor(new Var("Y"), new Var("Z"));
        Expression exp = a;
        exp = exp.assign("X", b);
        exp = exp.assign("Z", a);
        exp = exp.assign("Z", b);
        exp = exp.assign("Y", a);
        Expression new_exp = exp.assign("X", new Xnor(new Var("Z"), true));

        this.expressions.add(new_exp);
        this.expressions.add(exp);
    }*/

    public void add_ass_012() {
        Map<String, Boolean> ass00 = new TreeMap<>();

        Map<String, Boolean> ass11 = new TreeMap<>();
        ass11.put("X", true);
        Map<String, Boolean> ass12 = new TreeMap<>();
        ass12.put("X", false);

        Map<String, Boolean> ass21 = new TreeMap<>();
        ass21.put("X", true);
        ass21.put("Y", true);
        Map<String, Boolean> ass22 = new TreeMap<>();
        ass22.put("X", true);
        ass22.put("Y", false);
        Map<String, Boolean> ass23 = new TreeMap<>();
        ass23.put("X", false);
        ass23.put("Y", true);
        Map<String, Boolean> ass24 = new TreeMap<>();
        ass24.put("X", false);
        ass24.put("Y", false);

        this.assignments.add(ass00);
        this.assignments.add(ass11);
        this.assignments.add(ass12);
        this.assignments.add(ass21);
        this.assignments.add(ass22);
        this.assignments.add(ass23);
        this.assignments.add(ass24);
    }

    public void add_ass_3() {
        Map<String, Boolean> ass31 = new TreeMap<>();
        ass31.put("X", true);
        ass31.put("Y", true);
        ass31.put("Z", true);
        Map<String, Boolean> ass32 = new TreeMap<>();
        ass32.put("X", true);
        ass32.put("Y", true);
        ass32.put("Z", false);
        Map<String, Boolean> ass33 = new TreeMap<>();
        ass33.put("X", true);
        ass33.put("Y", false);
        ass33.put("Z", true);
        Map<String, Boolean> ass34 = new TreeMap<>();
        ass34.put("X", false);
        ass34.put("Y", true);
        ass34.put("Z", true);
        Map<String, Boolean> ass35 = new TreeMap<>();
        ass35.put("X", true);
        ass35.put("Y", false);
        ass35.put("Z", false);
        Map<String, Boolean> ass36 = new TreeMap<>();
        ass36.put("X", false);
        ass36.put("Y", true);
        ass36.put("Z", false);
        Map<String, Boolean> ass37 = new TreeMap<>();
        ass37.put("X", false);
        ass37.put("Y", false);
        ass37.put("Z", true);
        Map<String, Boolean> ass38 = new TreeMap<>();
        ass38.put("X", false);
        ass38.put("Y", false);
        ass38.put("Z", false);
        this.assignments.add(ass31);
        this.assignments.add(ass32);
        this.assignments.add(ass33);
        this.assignments.add(ass34);
        this.assignments.add(ass35);
        this.assignments.add(ass36);
        this.assignments.add(ass37);
        this.assignments.add(ass38);
    }

    public void add_ass_4() {
        Map<String, Boolean> ass41 = new TreeMap<>();
        ass41.put("W", true);
        ass41.put("X", true);
        ass41.put("Y", true);
        ass41.put("Z", true);
        Map<String, Boolean> ass42 = new TreeMap<>();
        ass42.put("W", true);
        ass42.put("X", true);
        ass42.put("Y", true);
        ass42.put("Z", false);
        Map<String, Boolean> ass43 = new TreeMap<>();
        ass43.put("W", true);
        ass43.put("X", true);
        ass43.put("Y", false);
        ass43.put("Z", true);
        Map<String, Boolean> ass44 = new TreeMap<>();
        ass44.put("W", true);
        ass44.put("X", false);
        ass44.put("Y", true);
        ass44.put("Z", true);
        Map<String, Boolean> ass45 = new TreeMap<>();
        ass45.put("W", true);
        ass45.put("X", true);
        ass45.put("Y", false);
        ass45.put("Z", false);
        Map<String, Boolean> ass46 = new TreeMap<>();
        ass46.put("W", true);
        ass46.put("X", false);
        ass46.put("Y", true);
        ass46.put("Z", false);
        Map<String, Boolean> ass47 = new TreeMap<>();
        ass47.put("W", true);
        ass47.put("X", false);
        ass47.put("Y", false);
        ass47.put("Z", true);
        Map<String, Boolean> ass48 = new TreeMap<>();
        ass48.put("W", true);
        ass48.put("X", false);
        ass48.put("Y", false);
        ass48.put("Z", false);
        Map<String, Boolean> ass49 = new TreeMap<>();
        ass49.put("W", false);
        ass49.put("X", true);
        ass49.put("Y", true);
        ass49.put("Z", true);
        Map<String, Boolean> ass4A = new TreeMap<>();
        ass4A.put("W", false);
        ass4A.put("X", true);
        ass4A.put("Y", true);
        ass4A.put("Z", false);
        Map<String, Boolean> ass4B = new TreeMap<>();
        ass4B.put("W", false);
        ass4B.put("X", true);
        ass4B.put("Y", false);
        ass4B.put("Z", true);
        Map<String, Boolean> ass4C = new TreeMap<>();
        ass4C.put("W", false);
        ass4C.put("X", false);
        ass4C.put("Y", true);
        ass4C.put("Z", true);
        Map<String, Boolean> ass4D = new TreeMap<>();
        ass4D.put("W", false);
        ass4D.put("X", true);
        ass4D.put("Y", false);
        ass4D.put("Z", false);
        Map<String, Boolean> ass4E = new TreeMap<>();
        ass4E.put("W", false);
        ass4E.put("X", false);
        ass4E.put("Y", true);
        ass4E.put("Z", false);
        Map<String, Boolean> ass4F = new TreeMap<>();
        ass4F.put("W", false);
        ass4F.put("X", false);
        ass4F.put("Y", false);
        ass4F.put("Z", true);
        Map<String, Boolean> ass4G = new TreeMap<>();
        ass4G.put("W", false);
        ass4G.put("X", false);
        ass4G.put("Y", false);
        ass4G.put("Z", false);
        this.assignments.add(ass41);
        this.assignments.add(ass42);
        this.assignments.add(ass43);
        this.assignments.add(ass44);
        this.assignments.add(ass45);
        this.assignments.add(ass46);
        this.assignments.add(ass47);
        this.assignments.add(ass48);
        this.assignments.add(ass49);
        this.assignments.add(ass4A);
        this.assignments.add(ass4B);
        this.assignments.add(ass4C);
        this.assignments.add(ass4D);
        this.assignments.add(ass4E);
        this.assignments.add(ass4F);
        this.assignments.add(ass4G);
    }

    public void test() {
        Map<String, String> results = new TreeMap<>();
        String key;
        String value;
        for (int i = 0; i < expressions.size(); i++) {
            int grade = 0;
            for (int j = 0; j < this.assignments.size(); j++) {
                key = i + "." + j;
                value = "";
                try {
                    value = value.concat((expressions.get(i)).evaluate(this.assignments.get(j)).toString());
                } catch (Exception e) {
                    value = value.concat("Exp");
                }
                value = value.concat(" ");
                try {
                    value = value.concat((expressions.get(i)).simplify().evaluate(this.assignments.get(j)).toString());
                } catch (Exception e) {
                    value = value.concat("Exp");
                }
                value = value.concat(" ");
                try {
                    value = value.concat((expressions.get(i)).nandify().evaluate(this.assignments.get(j)).toString());
                } catch (Exception e) {
                    value = value.concat("Exp");
                }
                value = value.concat(" ");
                try {
                    value = value.concat((expressions.get(i)).nandify().simplify().evaluate(this.assignments.get(j)).toString());
                } catch (Exception e) {
                    value = value.concat("Exp");
                }
                value = value.concat(" ");
                try {
                    value = value.concat((expressions.get(i)).norify().evaluate(this.assignments.get(j)).toString());
                } catch (Exception e) {
                    value = value.concat("Exp");
                }
                value = value.concat(" ");
                try {
                    value = value.concat((expressions.get(i)).norify().simplify().evaluate(this.assignments.get(j)).toString());
                } catch (Exception e) {
                    value = value.concat("Exp");
                }
                value = value.concat(" ");
                try {
                    value = value.concat((expressions.get(i)).simplify().simplify().evaluate(this.assignments.get(j)).toString());
                } catch (Exception e) {
                    value = value.concat("Exp");
                }
                value = value.concat("\n");
                // results.put(key, value);
                if (this.answers.get(key).equals(value)) {
                    grade += 1;
                    ++check;
                    System.out.println(grade);
                } else {
                    ++check;
                    integers.add(i);
                    integers1.add(j);
                    System.out.println(value.trim() + "(your answer)");
                }
                System.out.println(this.answers.get(key).trim() + " (expected answer)" + " (" + i + "." + j + ")");
            }
            // System.out.println(grade/this.assignments.size()*4 + " (" + i + ")");
        }
        // try {
        //     ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("a_12.out"));
        //     o.writeObject(results);
        // } catch (Exception e) {
        //     System.out.println("Error");
        // }
    }

    public static void tst() {
        Expression e = new And(new Var("X"), new Or(new Var("X"), new Xor(new Var("X"), new Nand(new Var("X"), new Nor(new Var("X"), new Xnor(new Var("X"), new Not(new Var("X"))))))));
        String s_nand = (e.nandify()).toString();
        String s_nor = (e.norify()).toString();
        Boolean x = false;
        if (s_nand.replace("X", "").replace(" ", "").replace("(", "").replace(")", "").replace("A", "").equals("")) {
            x = true;
        }
        System.out.println(x + " (nand test)");
        x = false;
        if (s_nor.replace("X", "").replace(" ", "").replace("(", "").replace(")", "").replace("V", "").equals("")) {
            x = true;
        }
        System.out.println(x + " (nor test)");
    }

    public static void main(String[] args) {
        Ass4 a_1 = new Ass4("C:\\Users\\avrah\\Desktop\\לימודים\\סמסטר ב' שנה א'\\הגשות תרגילים\\מבוא לתכנות מונחה עצמים\\תרגיל 4\\הגשה חדשה\\ass4\\src\\a_1.out");
        a_1.add_exp();
        a_1.add_ass_012();
        a_1.add_ass_3();
        a_1.add_ass_4();
        a_1.test();

        Ass4 a_2 = new Ass4("C:\\Users\\avrah\\Desktop\\לימודים\\סמסטר ב' שנה א'\\הגשות תרגילים\\מבוא לתכנות מונחה עצמים\\תרגיל 4\\הגשה חדשה\\ass4\\src\\a_2.out");
      //  a_2.add_comp_exp();
        a_2.add_ass_012();
        a_2.test();

        tst();
        System.out.println(check);
        System.out.println(integers);
        System.out.println(integers1);
    }
}