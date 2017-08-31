package com.liu.CatchYou.common.Basic.genericity.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon.liu on 2017/8/22.
 */
public class GenericClass<F> {
    private F mContent;
    public GenericClass(F mContent) {
        this.mContent = mContent;
    }

    public F getmContent() {
        return mContent;
    }

    public void setmContent(F mContent) {
        this.mContent = mContent;
    }

    public static void main(String[] args) {
        GenericClass<Integer> genericClass = new GenericClass(3.333);
        System.out.println(genericClass.getmContent());
        List<String> list = new ArrayList<>();
        List<GenericClass> list1 = new ArrayList<>();
        System.out.println(list.getClass() == list1.getClass());
    }
}
