package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        ArrayList<int[]> result = new ArrayList<int []>();
        result.add(new int[5]);
        result.add(new int[2]);
        result.add(new int[4]);
        result.add(new int[7]);
        result.add(new int[0]);
        for (int[] arr : result) {
            for (int i = 0; i < arr.length; i++)
                arr[i] = 1;
        }

        for (int[] arr : result) {
            for (int i : arr)
                System.out.print(i + " ");
            System.out.println();
        }
        return result;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
