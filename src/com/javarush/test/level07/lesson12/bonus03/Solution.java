package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(int[] array)
    {
        //напишите тут ваш код
        int maximum = 0;
        int maximum_index = 0;
        for (int i = 0; i < array.length; i++) {
            maximum = array[i];
            maximum_index = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] > array[maximum_index])
                {
                    maximum = array[j];
                    maximum_index = j;
                }
            }
            array[maximum_index] = array[i];
            array[i] = maximum;

        }
    }
}
