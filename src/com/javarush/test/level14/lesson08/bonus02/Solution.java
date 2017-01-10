package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int one = Integer.parseInt(reader.readLine());
        int two = Integer.parseInt(reader.readLine());

        for (int i = one; i > 0; i--)
        {
            if (one % i == 0 && two % i == 0)
            {
                System.out.println(i);
                break;
            }
        }
    }
}
