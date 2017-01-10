package com.javarush.test.level34.lesson08.bonus01;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (cache.get(key) != null) return cache.get(key);
        Constructor<V> constructor = clazz.getDeclaredConstructor(key.getClass());
        cache.put(key, constructor.newInstance(key));
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        Method method = null;
        try {
            method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            Object key = method.invoke(obj);
            cache.put((K) key,obj);
            return true;
        }
        catch (Exception ignore) {}
        return false;
    }

    public int size() {
        return cache.size();
    }
}
