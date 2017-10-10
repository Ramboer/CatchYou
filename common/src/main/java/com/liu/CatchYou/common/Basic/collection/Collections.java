package com.liu.CatchYou.common.Basic.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.*;

/**
 * Created by dmrj on 2017-06-23.
 */
public class Collections {

    public static void main(String[] args) {
        List<String> list1 = Lists.newArrayList();// 查询快，增删慢，数组实现, 有序可重复。
        List<String> list2 = Lists.newLinkedList();//查询慢，增删快，链表实现，有序可重复。
        Set<String> set = Sets.newHashSet();//存取速度快，哈希表实现，无序不可重复。
        for (int i = 0; i < 5; i++) {
            list1.add("list1 count : " + i);
            list2.add("list2 count : " + i);
            set.add("count : " + i);
        }
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(set);
        for (String str0: set) {
            System.out.println(str0);
        }
     }
}
