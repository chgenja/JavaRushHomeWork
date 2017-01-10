package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Kira on 14.01.2016.
 */
public class Singleton
{
    private static Singleton single;

    static Singleton getInstance()
    {
        if (single == null)
        {
            single = new Singleton();
            return single;
        }
        else
            return single;
    }

    private Singleton()
    {}


}
