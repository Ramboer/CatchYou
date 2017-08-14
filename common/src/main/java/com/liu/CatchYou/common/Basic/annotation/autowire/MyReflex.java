package com.liu.CatchYou.common.Basic.annotation.autowire;

import java.lang.reflect.Field;

/**
 * Created by simon.liu on 2017/7/25.
 */
public class MyReflex {
    public static boolean injectObject(Object object) {
        boolean res = false;
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            boolean isAuto = field.isAnnotationPresent(MyAutowire.class);
            if (isAuto) {
                Class clazzObject = (Class) field.getGenericType();
                try {
                    Object object1 = clazzObject.newInstance();
                    field.setAccessible(true);
                    field.set(object,object1);
                    res = true;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
}
