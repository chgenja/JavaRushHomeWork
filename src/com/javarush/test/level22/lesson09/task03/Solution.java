package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args)
    {
        //...
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String filename = reader.readLine();
            reader.close();
            Scanner scanner = new Scanner(new File(filename));
            String s = "";
            while (scanner.hasNextLine())
            {
                s += scanner.nextLine() + " ";
            }
        StringBuilder result = getLine(s.split(" "));
        System.out.println(result.toString());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        if ((words == null) || (words.length == 0))
            return new StringBuilder();
        if (words.length == 1)
        {
            for (String word : words)
                return new StringBuilder(word);
        }



        ArrayList<String> wordList = new ArrayList<>();
        for (String s : words)
            wordList.add(s);
        StringBuilder sb = new StringBuilder();
        while (true)
        {
            Collections.shuffle(wordList);
            boolean found = true;
            for (int i = 0; i < wordList.size()-1; i++)
            {
                String first = wordList.get(i).toLowerCase();
                String second = wordList.get(i+1).toLowerCase();
                if (first.charAt(first.length()-1) != second.charAt(0))
                {
                    found = false;
                    break;
                }
            }
            if (found)
            {
                for (int i = 0; i < wordList.size(); i++)
                    sb.append(wordList.get(i) + " ");
                sb.deleteCharAt(sb.length()-1);
                return sb;
            }

        }
    }
}
