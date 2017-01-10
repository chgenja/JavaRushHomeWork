package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by Kira on 21.07.2016.
 */
public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String s = "";
        try
        {
            s = reader.readLine();
            if (s.toUpperCase().equals(res.getString("operation.EXIT")))
            {
                writeMessage(res.getString("the.end"));
               throw new InterruptOperationException();
            }
        } catch (IOException e)
        {

        }
        return s;

    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        while (true)
        {
            writeMessage(res.getString("choose.currency.code"));
            String currencyCode = readString();
            if (currencyCode.length() != 3)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
                return currencyCode.toUpperCase();
        }

    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        while (true)
        {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            String enter = readString();
            String[] digits = enter.split(" ");
            if (digits.length != 2)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            try {
                Integer.parseInt(digits[0]);
                Integer.parseInt(digits[1]);
            } catch (NumberFormatException e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if ((Integer.parseInt(digits[0]) < 0) || (Integer.parseInt(digits[1]) < 0))
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            return digits;

        }
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        writeMessage(res.getString("choose.operation") + " 1 - " + res.getString("operation.INFO") + ", 2 - " + res.getString("operation.DEPOSIT") + ", 3 - " + res.getString("operation.WITHDRAW") + ", 4 - "+ res.getString("operation.EXIT"));
        while (true)
        {
            String operationString = readString();
            int operationIndex;
            try
            {
                operationIndex = Integer.parseInt(operationString);
            }
            catch (NumberFormatException e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            operationIndex = Integer.parseInt(operationString);
            try
            {
                Operation operation = Operation.getAllowableOperationByOrdinal(operationIndex);
            } catch (IllegalArgumentException e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            return Operation.getAllowableOperationByOrdinal(operationIndex);
        }
    }
}
