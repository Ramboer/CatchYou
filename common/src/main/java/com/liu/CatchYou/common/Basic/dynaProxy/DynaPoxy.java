package com.liu.CatchYou.common.Basic.dynaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by simon.liu on 2017/7/10.
 */
public class DynaPoxy implements InvocationHandler{
    private Object proxy;
    private Object delegate;
    public Object bind (Object proxy, Object delegate) {
        this.proxy = proxy;
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        Class clazz = this.proxy.getClass();
        Method start = clazz.getDeclaredMethod("start",new Class[]{Method.class});
        start.invoke(this.proxy,new Object[]{method});
        result = method.invoke(delegate,args);
        Method end = clazz.getDeclaredMethod("end", new Class[]{Method.class});
        end.invoke(this.proxy, new Object[]{method});
        return result;
    }

    public static void main(String[] args) {
        IHello iHello = (IHello) new DynaPoxy().bind(new LogProxy(), new Hello());
        iHello.sayHello("liu-xu");
    }
}
