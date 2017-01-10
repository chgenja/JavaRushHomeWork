package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);
        if (((b<a) && (a<c)) || ((c<a) && (a<b)))
            System.out.println(a);
        if ((a<b && b<c) || (c<b && b<a))
            System.out.println(b);
        if ((a<c && c<b) || (b<c && c<a))
            System.out.println(c);
    }
}
