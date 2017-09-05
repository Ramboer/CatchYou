package com.liu.CatchYou.common.Basic.threads.threadone;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by simon.liu on 2017/9/5.
 */
public class Cache {
    private static Map<String, Object>  cache = new HashMap<>();
    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static Lock rLock = rwl.readLock();
    private static Lock wLock = rwl.writeLock();
    public static Object writeToCache(String key, Object value) {
        wLock.lock();
        try {
            return cache.put(key, value);
        } finally {
            wLock.unlock();
        }
    }

    public static Object readCache(String key) {
        rLock.lock();
        try {
            return cache.get(key);
        } finally {
            rLock.unlock();
        }
    }

    public static void clearCache() {
        wLock.lock();
        try {
            cache.clear();
        } finally {
            wLock.unlock();
        }
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
    }
 }
