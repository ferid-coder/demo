/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theproject;

/**
 *
 * @author ferid
 */
public class TheProject {

    public static int i = 0;
    static String s = "51Pa*0Lp*0e";
    //  static StringBuffer s1 = new StringBuffer(s);
    static StringBuffer sb = new StringBuffer(s);

    public static void main(String[] args) {
        decryptPassword("");
    }

    public static String decryptPassword(String ss) {

        int value = s.length();

        int foo = Character.getNumericValue(s.charAt(0));
        if (foo > 0) {
            if (s.charAt(0) == '5') {

                sb = sb.delete(0, 1);
                sb.setCharAt(8, '5');

                //Pa*0Lp*5e
            }
            if (sb.charAt(0) == '1') {

                sb = sb.delete(0, 1);
                sb.setCharAt(3, '1');
                System.out.println(sb);
            }
            if (Character.isLowerCase(sb.charAt(1))) {//Pa*1Lp*5e
                String message = sb.toString();
                String[] strings = message.split("\\s+");

                for (int i = strings.length - 1; i >= 0; i--) {
                    sb.append(strings[i] + " ");
                }
                System.out.println(sb.toString().trim());
            }
        }

        return "";
    }

}
