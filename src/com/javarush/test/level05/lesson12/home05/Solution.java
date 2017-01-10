package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String enter = "";
        while (!enter.equals("сумма")) {
            enter = reader.readLine();
            if (!enter.equals("сумма"))
            {
                int i = Integer.parseInt(enter);
                sum = sum + i;
            }
        }
        System.out.println(sum);
    }
}
