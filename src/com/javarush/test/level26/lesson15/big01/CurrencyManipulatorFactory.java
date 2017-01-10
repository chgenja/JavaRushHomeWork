package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kira on 25.07.2016.
 */
public final class CurrencyManipulatorFactory
{
    private static Map<String, CurrencyManipulator> manipulators = new HashMap();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (manipulators.containsKey(currencyCode))
        {
            return manipulators.get(currencyCode);
        } else
        {
            CurrencyManipulator newOne = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode, newOne);
            return newOne;
        }
    }

    public static Collection getAllCurrencyManipulators()
    {
        return manipulators.values();
    }

    private CurrencyManipulatorFactory()
    {
    }
}
