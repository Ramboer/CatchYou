package com.liu.CatchYou.common.Basic.grammer;

/**
 * Created by dmrj on 2017-06-23.
 */
public class Grammer {
    private static String var1;
    private static String var2;
    private static String var3;
    private static final int INT_VAR = 1010;
            static {
                var1 = "112233";
                var2 = "223344";
                var3 = "334455";
            }

    public static void main(String[] args) {
        System.out.println(var1);
        System.out.println(var2);
        var2 = "123";
        System.out.println(var2);
        System.out.println(var3);
        new Grammer().change();
        System.out.println(INT_VAR);
    }

    public void change() {
                var2 = "o";
        System.out.println(var2);
        System.out.println(INT_VAR);
    }
}
