package com.liu.CatchYou.common.Basic.dynaProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by simon.liu on 2017/7/10.
 */
public class LogProxy implements Iproxy{
    public void start(Method method) {
        System.out.println(new Date() + " invoke method " + method.getName() + " start..." );
    }

    public void end(Method method) {
        System.out.println(new Date() + " invoke " + method.getName() + " end.");
    }
}
