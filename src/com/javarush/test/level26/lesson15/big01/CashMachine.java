package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by Kira on 21.07.2016.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args) throws IOException
    {

        Locale.setDefault(Locale.ENGLISH);
        try
        {
            CommandExecutor.execute(Operation.LOGIN);
        }
        catch (InterruptOperationException e)
        {
            e.printStackTrace();
        }
        try
        {
            Operation operation = null;
            do
            {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            } while (!operation.equals(Operation.EXIT));
        }
        catch (InterruptOperationException e)
        {

        }
    }
}