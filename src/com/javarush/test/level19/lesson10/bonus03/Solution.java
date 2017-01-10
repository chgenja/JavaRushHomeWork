package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        String tag = args[0];

        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"));
        String content = "";
        while (fileReader.ready())
        {
            content += fileReader.readLine();
        }
        fileReader.close();

        Map<Integer,Boolean> tagIndexes = new TreeMap<>();
        for (int i = 0; i < content.length() - tag.length(); i++)
        {
            if (content.substring(i).length() > tag.length() && content.substring(i,i+tag.length()+1).equals("<" + tag))
            {
                tagIndexes.put(i, true);
            }
            if (content.substring(i).length() > tag.length()+1 && content.substring(i,i+tag.length()+2).equals("</"+tag))
            {
                tagIndexes.put(i, false);
            }
        }

        LinkedList<Integer> support = new LinkedList<>();
        Map<Integer,Integer> rows = new TreeMap<>();

        for (Map.Entry<Integer,Boolean> pair : tagIndexes.entrySet())
        {
            if (pair.getValue())
                support.add(pair.getKey());
            else
            {
                rows.put(support.getLast(),pair.getKey());
                support.remove(support.getLast());
            }
        }

        for (Map.Entry<Integer,Integer> pair: rows.entrySet())
            System.out.println(content.substring(pair.getKey(),pair.getValue()+3+tag.length()));



    }
}