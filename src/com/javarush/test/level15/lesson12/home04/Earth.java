package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Kira on 19.01.2016.
 */
public class Earth implements Planet
{
    private static Earth ourInstance;

    public static Earth getInstance()
    {
        if (ourInstance == null)
            ourInstance = new Earth();
        return ourInstance;
    }
    private Earth()
    {
    }
}
