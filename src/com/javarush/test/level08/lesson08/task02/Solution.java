package com.javarush.test.level08.lesson08.task02;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 20; i++)
            set.add(i);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() > 10)
                iterator.remove();
        }
        return set;
    }

    public static void main(String[] args) throws IOException {

        HashSet<Integer> newset = createSet();
        newset = removeAllNumbersMoreThan10(newset);
        for (Integer i : newset) {
            System.out.println(i);
        }
    }
}
