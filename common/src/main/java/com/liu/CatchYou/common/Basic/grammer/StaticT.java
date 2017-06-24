package com.liu.CatchYou.common.Basic.grammer;

/**
 * Created by dmrj on 2017-06-23.
 */
public class StaticT {
    /**
     *  static 变量，对象之间共享值，方便访问变量
     */
    private static String var1;
    private static String var2;
    private static String var3;

    /**
     * static final用来修饰成员变量和成员方法，可简单理解为“全局常量”.
     * 对于变量，表示一旦给值就不可修改，并且通过类名可以访问。
     * 对于方法，表示不可覆盖，并且可以通过类名直接访问。
     */
    private static final int INT_VAR = 1010;

    /**
     * static代码块也叫静态代码块，
     * 是在类中独立于类成员的static语句块，
     * 可以有多个，位置可以随便放，
     * 它不在任何的方法体内，JVM加载类时会执行这些静态的代码块，
     * 如果static代码块有多个，JVM将按照它们在类中出现的先后顺序依次执行它们，
     * 每个代码块只会被执行一次。
     */
            static {
                var1 = "112233";
                var2 = "223344";
                var3 = "334455";
            }

    /**
     * static function
     * 静态方法可以直接通过类名调用，任何的实例也都可以调用.
     * 静态方法是类内部的一类特殊方法，只有在需要时才将对应的方法声明成静态的.
     * 一个类内部的方法一般都是非静态的
     * 利用静态代码块可以对一些static变量进行赋值
     * @return String
     */
    public static String getStringValue() {
                return "value 0f static function.";
    }

    public static void main(String[] args) {
        System.out.println(var1);
        System.out.println(var2);
        var2 = "123";
        System.out.println(var2);
        System.out.println(var3);
        new StaticT().change();
        System.out.println(INT_VAR);
    }

    public void change() {
                var2 = "o";
        System.out.println(var2);
        System.out.println(INT_VAR);
    }
}
