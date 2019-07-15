package com.nicro.mainapp.test;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.LruCache;

import java.util.Iterator;
import java.util.LinkedHashMap;
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

        System.out.println("==================LruCache====================");

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
        System.out.println("name5:" + lruCache.get("name5"));

        /*System.out.println("==================HashMap====================");
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("name1", 1);
        hashMap.put("name2", 2);
        hashMap.put("name3", 3);
        hashMap.put("name4", 4);*/

        System.out.println("============================ordered access=======================================");

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("name1", 1);
        linkedHashMap.put("name2", 2);
        linkedHashMap.put("name3", 3);
        linkedHashMap.put("name4", 4);
        linkedHashMap.put("name5", 5);
        linkedHashMap.put("name6", 6);
        linkedHashMap.put("name7", 7);
        linkedHashMap.put("name8", 8);
        linkedHashMap.put("name9", 9);
        Set<Map.Entry<String, Integer>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String key = (String) entry.getKey();
            int value = (Integer) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

        System.out.println("通过get方法，导致key为name1对应的Entry到表尾");
        linkedHashMap.put("name1", (linkedHashMap.get("name1") + 1));
        linkedHashMap.put("name5", (linkedHashMap.get("name5") + 1));
        Set<Map.Entry<String, Integer>> set2 = linkedHashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            String key = (String) entry.getKey();
            int value = (Integer) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

        ArrayMap<String, Integer> arrayMap = new ArrayMap();
        arrayMap.put("name1", 1);

        LRULinkedHashMap<ArrayMap, String> lruLinkedHashMap = new LRULinkedHashMap<>(5);
        lruLinkedHashMap.put(arrayMap, "name1");

        Goods goods = new Goods("name1", 1);
        Goods goods2 = null;
        try {
            goods2 = (Goods) goods.clone();
            System.out.println(goods == goods2);//false
            System.out.println(goods);
            System.out.println(goods2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        LRULinkedHashMap<Goods, Boolean> cache = new LRULinkedHashMap<>(5);
        cache.put(goods, true);
        cache.put(goods2, true);

        Set<Map.Entry<Goods, Boolean>> cacheSet = cache.entrySet();
        Iterator<Map.Entry<Goods, Boolean>> cacheIterator = cacheSet.iterator();
        while (cacheIterator.hasNext()) {
            Map.Entry entry = cacheIterator.next();
            Goods key = (Goods) entry.getKey();
            Boolean value = (Boolean) entry.getValue();
            System.out.println("key:" + key + ",value:" + value);
        }

    }

    public static void maxSizeInMap(LinkedHashMap<String, Integer> linkedHashMap, int maxSize) {

    }
}
