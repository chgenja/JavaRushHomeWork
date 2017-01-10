package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Kira on 25.07.2016.
 */
public class CurrencyManipulator
{
    String currencyCode;
    Map<Integer,Integer> denominations = new HashMap<>();

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination)+count);
        } else
        {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount()
    {
        int amount = 0;
        for (Map.Entry<Integer,Integer> pair : denominations.entrySet())
            amount += pair.getKey()*pair.getValue();
        return amount;
    }

    public boolean hasMoney()
    {
        return getTotalAmount()>0;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        List<Integer> bills = new ArrayList<>();
        Map<Integer,Integer> denominationsClone = new HashMap<>();

        for (Map.Entry<Integer, Integer> pair : denominations.entrySet())
        {
            bills.add(pair.getKey());
            denominationsClone.put(pair.getKey(),pair.getValue());
        }
        Collections.sort(bills);


        Map<Integer, Integer> returnedDenominations = new HashMap<>();
        int leftAmount = expectedAmount;


        for (int i = bills.size()-1; i >=0; i--)
        {
            int billCount = leftAmount / bills.get(i);
            if (billCount == 0)
                continue;
            if (billCount > denominationsClone.get(bills.get(i)))
                billCount = denominationsClone.get(bills.get(i));
            returnedDenominations.put(bills.get(i),billCount);
            denominationsClone.put(bills.get(i),denominationsClone.get(bills.get(i))-billCount);
            if (denominationsClone.get(bills.get(i)) == 0)
                denominationsClone.remove(bills.get(i));
            leftAmount -= bills.get(i)*billCount;
        }
        if (leftAmount > 0)
            throw new NotEnoughMoneyException();
        denominations = denominationsClone;
        return returnedDenominations;


    }


}
