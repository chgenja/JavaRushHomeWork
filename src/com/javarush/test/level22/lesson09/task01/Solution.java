package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        Scanner scanner = new Scanner(new File(filename));
        String allWords = "";
        StringBuilder sb = new StringBuilder(allWords);
        while (scanner.hasNextLine())
        {
            String s = scanner.nextLine();
            sb.append(s);
            sb.append(" ");
        }
        scanner.close();

        while (sb.indexOf(" ")!= -1)
        {
            String word = sb.substring(0,sb.indexOf(" "));
            String reversedWord = new StringBuilder(word).reverse().toString();
            if ((sb.indexOf(reversedWord,sb.indexOf(" ")) != -1) && (sb.indexOf(word) != sb.indexOf(reversedWord,sb.indexOf(" "))))
            {
                Pair pair = new Pair();
                pair.first = word;
                pair.second = reversedWord;
                result.add(pair);
                sb.delete(sb.indexOf(reversedWord, sb.indexOf(" ")),sb.indexOf(reversedWord, sb.indexOf(" "))+reversedWord.length()+1);
                sb.delete(0,sb.indexOf(" ")+1);
            } else
            {
                sb.delete(0,sb.indexOf(" ")+1);
            }

        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
