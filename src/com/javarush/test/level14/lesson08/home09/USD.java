package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Kira on 12.01.2016.
 */
public class USD extends Money
{
    public String getCurrencyName() {return "USD";}

    public USD (double amount)
    {
        super(amount);
    }
}
