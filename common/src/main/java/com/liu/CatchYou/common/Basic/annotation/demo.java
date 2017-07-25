package com.liu.CatchYou.common.Basic.annotation;

/**
 * Created by simon.liu on 2017/7/25.
 */
@Description("i am demo class.")
public class demo {
   private String name;
   private int id;
   @Description("i am demo method.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
