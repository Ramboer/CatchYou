package com.liu.CatchYou.common.Basic.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by simon.liu on 2017/7/10.
 */
public class Hello {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Object object = Class.forName(Hello.class.getName()).newInstance();
        Method[] methods = object.getClass().getMethods();
        for (Method method : methods) {
            if ("setName".equals(method.getName().intern())) {
                method.invoke(object,"liu-xu");
            }
        }

        for (Method method : methods) {
            if ("getName".equals(method.getName())) {
                String name1 = (String) method.invoke(object);
                System.out.println(name1);
               }
        }

    }
}
