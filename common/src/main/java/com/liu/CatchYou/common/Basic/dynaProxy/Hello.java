package com.liu.CatchYou.common.Basic.dynaProxy;

/**
 * Created by simon.liu on 2017/7/10.
 */
public class Hello implements IHello{

    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
