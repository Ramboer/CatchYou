package com.liu.CatchYou.common.Basic.dynaProxy;

import java.lang.reflect.Method;

/**
 * Created by simon.liu on 2017/7/10.
 */
public interface Iproxy {
    void start(Method method);
    void end(Method method);
}
