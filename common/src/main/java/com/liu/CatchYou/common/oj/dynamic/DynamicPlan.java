package com.liu.CatchYou.common.oj.dynamic;

/**
 * Created by simon.liu on 2017/8/9.
 */
public class DynamicPlan {
    public static int dynamicCalc(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(dynamicCalc(100));
    }
}
