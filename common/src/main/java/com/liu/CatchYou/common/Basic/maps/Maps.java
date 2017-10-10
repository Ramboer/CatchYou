package com.liu.CatchYou.common.Basic.maps;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by dmrj on 2017-06-23.
 */
public class Maps {
    public static void main(String[] args) {
        Map<String, String> map1 = com.google.common.collect.Maps.newHashMap();
        Map<String, String> map2 = com.google.common.collect.Maps.newLinkedHashMap();
        for (int i = 0; i < 5; i++) {
            map1.put(""+ i,  i + "");
            map2.put("" + i,  i + "" );
        }
        System.out.println(map1);
        System.out.println(map2);

        if ( map1.keySet().contains("1")) {
            System.out.println("yes" +
                    "111");
        }

        System.out.println(map1.values());

        Iterator iterator = map1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
        }
        /*Iterator iterator = map1.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            System.out.println("key : " + key + "value : " + map1.get(key));
        }*/
    }
}
