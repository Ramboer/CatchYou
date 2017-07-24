package com.liu.CatchYou.common.Basic.grammer;

/**
 * Created by simon.liu on 2017/7/13.
 */
public class Native {
    public static native double sqrt(double a);

    public static void main(String[] args) {
        System.out.println(String.valueOf(sqrt(100)));
    }
}
