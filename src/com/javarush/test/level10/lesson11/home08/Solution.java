package com.javarush.test.level10.lesson11.home08;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String> list_1 = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
            list_1.add("List 1, element " + i);
        ArrayList<String> list_2 = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
            list_2.add("List 2, element " + i);
        ArrayList<String> list_3 = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
            list_3.add("List 3, element " + i);
        ArrayList[] resultarray = new ArrayList[3];
        resultarray[0] = list_1;
        resultarray[1] = list_2;
        resultarray[2] = list_3;

        return resultarray;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}