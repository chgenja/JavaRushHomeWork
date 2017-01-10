package com.javarush.test.level30.lesson04.home01;

import java.util.Locale;
import java.util.concurrent.TransferQueue;

/**
 * Created by Kira on 06.10.2016.
 */
public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 1; i <= 9; i++)
            {
                System.out.format("Элемент 'ShareItem-%d' добавлен\n",i);
                queue.offer(new ShareItem(String.format("ShareItem-%d",i),i));
                Thread.sleep(100);
                if (queue.hasWaitingConsumer())
                    System.out.format("Consumer в ожидании!\n");
            }
        } catch (InterruptedException e)
        {
        }
    }
}
