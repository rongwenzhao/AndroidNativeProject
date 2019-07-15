package com.nicro.mainapp.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 6802031150943192407L;
    private int capacity;

    LRULinkedHashMap(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
