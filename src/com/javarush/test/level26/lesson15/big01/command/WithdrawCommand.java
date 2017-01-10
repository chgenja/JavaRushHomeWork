package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Kira on 30.07.2016.
 */
class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String amountStr = ConsoleHelper.readString();
            try {
                Integer.parseInt(amountStr);
            } catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            int amount = Integer.parseInt(amountStr);
            if (!currencyManipulator.isAmountAvailable(amount))
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            if (amount < 0)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                throw new NumberFormatException();
            }
            try
            {
                Map<Integer, Integer> returnedDenominations = currencyManipulator.withdrawAmount(amount);
                List<Integer> bills = new ArrayList<>();
                for (Map.Entry<Integer, Integer> pair : returnedDenominations.entrySet())
                    bills.add(pair.getKey());
                Collections.sort(bills);
                int sum = 0;
                for (int i = bills.size()-1; i>=0; i--)
                {
                    ConsoleHelper.writeMessage("\t" + bills.get(i) + " - " + returnedDenominations.get(bills.get(i)));
                    sum += bills.get(i)*returnedDenominations.get(bills.get(i));
                }
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"),sum,currencyCode));
                break;
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }

        }
    }
}
