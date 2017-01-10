package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.OurHashMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.StorageStrategy;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kira on 26.12.2016.
 */
public class Solution {
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s: strings) {
            result.add(shortener.getId(s));
        }
        return result;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long l : keys) {
            result.add(shortener.getString(l));
        }
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> testStrings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
            testStrings.add(Helper.generateRandomString());
        Shortener shortener = new Shortener(strategy);

        Set<Long> ids;
        Date startDateGetIds = new Date();
        ids = getIds(shortener,testStrings);
        Date endDateGetIds = new Date();
        long getIdsTime = endDateGetIds.getTime() - startDateGetIds.getTime();
        Helper.printMessage(Long.toString(getIdsTime));

        Set<String> strings;
        Date startDateGetStrings = new Date();
        strings = getStrings(shortener,ids);
        Date endDateGetStrings = new Date();
        long getStringsTime = endDateGetStrings.getTime() - startDateGetStrings.getTime();
        Helper.printMessage(Long.toString(getStringsTime));

        if (testStrings.equals(strings))
            Helper.printMessage("Тест пройден.");
        else
            Helper.printMessage("Тест не пройден.");
    }

    public static void main(String[] args) {
        StorageStrategy strategy = new HashMapStorageStrategy();
        testStrategy(strategy,10000);
        StorageStrategy strategy2 = new OurHashMapStorageStrategy();
        testStrategy(strategy2, 10000);
    }
}
