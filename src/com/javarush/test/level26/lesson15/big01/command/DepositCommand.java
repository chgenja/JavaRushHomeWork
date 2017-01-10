package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Kira on 30.07.2016.
 */
class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        try
        {
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            String[] denomination = ConsoleHelper.getValidTwoDigits(currencyCode);
            currencyManipulator.addAmount(Integer.parseInt(denomination[0]), Integer.parseInt(denomination[1]));
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(denomination[0]) * Integer.parseInt(denomination[1]), currencyCode));
        } catch (InterruptOperationException e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }
}
