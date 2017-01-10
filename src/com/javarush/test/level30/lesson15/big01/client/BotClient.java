package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Kira on 16.10.2016.
 */
public class BotClient extends Client {
    private static int count = -1;

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);
            if (message.indexOf(":")==-1)
            {
                return;
            }
            String name = message.substring(0, message.indexOf(":"));
            String text = message.substring(message.indexOf(":")+2);
            String result = "Информация для " + name + ": ";
            SimpleDateFormat format = null;
            switch (text) {
                case "дата": {
                    format = new SimpleDateFormat("d.MM.YYYY");
                    break;
                }
                case "день": {
                    format = new SimpleDateFormat("d");
                    break;
                }
                case "месяц": {
                    format = new SimpleDateFormat("MMMM");
                    break;
                }
                case "год": {
                    format = new SimpleDateFormat("YYYY");
                    break;
                }
                case "время": {
                    format = new SimpleDateFormat("H:mm:ss");
                    break;
                }
                case "час": {
                    format = new SimpleDateFormat("H");
                    break;
                }
                case "минуты": {
                    format = new SimpleDateFormat("m");
                    break;
                }
                case "секунды": {
                    format = new SimpleDateFormat("s");
                    break;
                }
                default: {
                    return;
                }
            }
            sendTextMessage(result + format.format(Calendar.getInstance().getTime()));

        }
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        count++;
        if (count > 99)
            count = 0;
        return "date_bot_" + count;
    }



    public static void main(String[] args) {
        new BotClient().run();
    }
}
