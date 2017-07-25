package com.liu.CatchYou.common.Basic.annotation.autowire;

/**
 * Created by simon.liu on 2017/7/25.
 */
public class Demo {
    @MyAutowire
    public Apple apple;

    public void say() {
        apple.say();
    }
}
