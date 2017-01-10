package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.io.Console;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Kira on 30.07.2016.
 */
class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");
    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        Boolean hasMoney = false;
        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        for (CurrencyManipulator manipulator : manipulators)
        {
            if (manipulator.hasMoney())
            {
                hasMoney = true;
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }

        if (!hasMoney)
            ConsoleHelper.writeMessage(res.getString("no.money"));

    }
}
