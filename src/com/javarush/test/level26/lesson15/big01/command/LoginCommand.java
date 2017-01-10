package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.File;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Kira on 05.08.2016.
 */
class LoginCommand implements Command
{
    private final String cardNumber = "123456789012";
    private final String pin = "1234";
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String enteredCardNumber = ConsoleHelper.readString();
            if ((enteredCardNumber.length() != 12) || (!enteredCardNumber.matches("^\\d{12}$")))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            String enteredPin = ConsoleHelper.readString();
            if ((enteredPin.length() != 4) || (!enteredPin.matches("^\\d{4}$")))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            if (((validCreditCards.containsKey(enteredCardNumber))) && (validCreditCards.getString(enteredCardNumber).equals(enteredPin)))
            {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"),enteredCardNumber));
                break;
            } else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), enteredCardNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }

        }
    }
}
