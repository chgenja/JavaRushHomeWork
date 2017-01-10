package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        for (int i = 0; i < (s.length()-1); i++)
        {
            if ((s.substring(i,i+1).equals(" ")) && (s.substring(i+1,i+2) != " "))
                s = s.substring(0,i+1) + s.substring(i+1,i+2).toUpperCase() + s.substring(i+2);
        }
        System.out.println(s);
    }


}
