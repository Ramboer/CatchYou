package com.liu.CatchYou.common.Basic.genericity;

/**
 * Created by simon.liu on 2017/8/22.
 */
public class Generic {
    private Object[] data;

    public Generic(int capacity) {
        this.data = new Object[capacity];
    }
    public void add(int index, Object item) {
        data[index] = item;
    }

    public Object get(int index) {
        return data[index];
    }

    public static void main(String[] args) {
        Generic generic = new Generic(5);
        generic.add(0, 123);
        generic.add(1, "liuXu");
        String a = (String) generic.get(0);
    }
}
