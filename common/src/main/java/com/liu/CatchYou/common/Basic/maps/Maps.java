package com.liu.CatchYou.common.Basic.maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dmrj on 2017-06-23.
 */
public class Maps {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<String, String>();
        Map<String, String> map2 = new LinkedHashMap<String, String>();
        for (int i = 0; i < 5; i++) {
            map1.put(""+ i,  i + "");
            map2.put("" + i,  i + "" );
        }
        System.out.println(map1);
        System.out.println(map2);

        Iterator iterator = map1.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            System.out.println("key : " + key + "value : " + map1.get(key));
        }
    }
}
