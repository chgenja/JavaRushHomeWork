package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution
{
    public static List<String> getFileTree(String root) throws IOException
    {
        File rootFile = new File(root);
        Queue<File> queue = new ArrayDeque<>();
        List<String> result = new ArrayList<>();
        for (File f : rootFile.listFiles())
            queue.add(f);
        while (queue.size() > 0)
        {
            File current = queue.element();
            if (current.isDirectory())
            {
                for (File f : current.listFiles())
                    queue.add(f);
            } else if (current.isFile())
                result.add(current.getAbsolutePath());
            queue.remove();
        }
        return result;
    }

    public static void main(String[] args) throws IOException
    {
        List<String> result = getFileTree("D:\\NotGames\\java\\JavaRushHomeWork\\src\\com\\javarush\\test\\level31\\lesson02\\home02");
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }
}