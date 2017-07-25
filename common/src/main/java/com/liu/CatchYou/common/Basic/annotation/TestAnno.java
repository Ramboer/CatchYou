package com.liu.CatchYou.common.Basic.annotation;

import java.lang.reflect.Method;

/**
 * Created by simon.liu on 2017/7/25.
 */
public class TestAnno {
    public static void main(String[] args){
        Class dm = null;
        try {
            dm = Class.forName("com.liu.CatchYou.common.Basic.annotation.demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean isExist = dm.isAnnotationPresent(Description.class);
        if (isExist) {
            Description description = (Description) dm.getAnnotation(Description.class);
            System.out.println(description.value());
        }
        Method[] methods = dm.getMethods();
        for(Method method : methods) {
            boolean isExistMes = method.isAnnotationPresent(Description.class);
            if (isExistMes) {
                Description description = (Description) method.getAnnotation(Description.class);
                System.out.println(description.value());
            }
        }
    }
}
