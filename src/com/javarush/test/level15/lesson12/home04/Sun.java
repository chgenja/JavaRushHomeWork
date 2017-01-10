package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Kira on 19.01.2016.
 */
public class Sun implements Planet
{
    private static Sun ourInstance;

    public static Sun getInstance()
    {
        if (ourInstance == null)
            ourInstance = new Sun();
        return ourInstance;
    }

    private Sun()
    {
    }
}
