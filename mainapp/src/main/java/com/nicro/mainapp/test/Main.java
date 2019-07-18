package com.nicro.mainapp.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        /*Map<String, Integer> seqMap = new LinkedHashMap<>();
        seqMap.put("c", 100);
        seqMap.put("d", 200);
        seqMap.put("a", 500);
        seqMap.put("d", 300);
        for (Map.Entry<String, Integer> entry : seqMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("=====================================================================");

        Map<String, Integer> accessMap = new LinkedHashMap<>(16, 0.75f, true);
        accessMap.put("c", 100);
        accessMap.put("d", 200);
        accessMap.put("a", 500);
        accessMap.get("c");
        accessMap.put("d", 300);
        for (Map.Entry<String, Integer> entry : accessMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/

        /*System.out.println("==================LruCache====================");

        LruCache lruCache = new LruCache(3);
        lruCache.put("name1", 1);
        lruCache.put("name2", 2);
        lruCache.put("name3", 3);
        lruCache.put("name4", 4);

        lruCache.get("name2");
        lruCache.put("name5", 5);

        System.out.println("name1:" + lruCache.get("name1"));
        System.out.println("name2:" + lruCache.get("name2"));
        System.out.println("name3:" + lruCache.get("name3"));
        System.out.println("name4:" + lruCache.get("name4"));
        System.out.println("name5:" + lruCache.get("name5"));*/

        /*System.out.println("==================HashMap====================");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("name1", 1);
        hashMap.put("name2", 2);
        hashMap.put("name3", 3);
        hashMap.put("name4", 4);*/

        System.out.println("============================ordered access=======================================");

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("name1", 1);
        linkedHashMap.put("name2", 2);
        linkedHashMap.put("name3", 3);
        linkedHashMap.put("name4", 4);
        linkedHashMap.put("name5", 5);
        linkedHashMap.put("name6", 6);
        linkedHashMap.put("name7", 7);
        linkedHashMap.put("name8", 8);
        linkedHashMap.put("name9", 9);
        linkedHashMap.put("name2", 222);

        printLinkedHashMap(linkedHashMap);

        System.out.println("通过get方法，导致get key后的Entry到表尾");
        linkedHashMap.put("name1", (linkedHashMap.get("name1") + 1));
        linkedHashMap.put("name5", (linkedHashMap.get("name5") + 1));
        linkedHashMap.get("name9");
        linkedHashMap.put("name1", 111);

        printLinkedHashMap(linkedHashMap);

        System.out.println("==================get more==================");
        linkedHashMap.get("name1");
        printLinkedHashMap(linkedHashMap);

        LinkedHashMap result = new LinkedHashMap();

        System.out.println("==================反转列表元素==================");
        reverseLinkedHashMap(linkedHashMap, result);

        printLinkedHashMap(result);
    }

    public static void printLinkedHashMap(LinkedHashMap linkedHashMap) {
        Set<Map.Entry<String, Integer>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            int value = (Integer) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }
    }

    //LinkedHashMap的倒序
    public static void reverseLinkedHashMap(LinkedHashMap<String, Integer> ori, LinkedHashMap<String, Integer> result) {
        //新的结果集合  result是传进来的
        LinkedHashMap<String, Integer> linkResult = new LinkedHashMap<>();
        ListIterator<Map.Entry<String, Integer>> iterator =
                new ArrayList<>(ori.entrySet()).listIterator(ori.size());
        while (iterator.hasPrevious()) {
            Map.Entry<String, Integer> previous = iterator.previous();
            String key = previous.getKey();
            Integer value = previous.getValue();
            linkResult.put(key, value);
        }
        result.clear();
        result.putAll(linkResult);
    }
}
