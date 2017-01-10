package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;

        //напишите тут ваш код
        String count = "";
        int N = 0;
        while (N<=0) {
            count = reader.readLine();
            N = Integer.parseInt(count);
        }

        String maximumStr = reader.readLine();
        maximum = Integer.parseInt(maximumStr);
        for (int i = 2; i <= N; i++) {
            maximum = max(maximum, Integer.parseInt(reader.readLine()));
        }

        System.out.println(maximum);
    }

    public static int max(int a, int b) {
        if (a>b)
            return a;
        else
            return b;
    }
}
