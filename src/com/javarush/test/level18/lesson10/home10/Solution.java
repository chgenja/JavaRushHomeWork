package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameOutput = null;
        Set<String> set = new TreeSet<String> (new Comparator<String>() {
            @Override
            public int compare(String a, String b)
            {
                int o1 = Integer.parseInt(a.substring(a.lastIndexOf(".") + 5, a.length()));
                int o2 = Integer.parseInt(b.substring(b.lastIndexOf(".") + 5, b.length()));
                return o1 > o2 ? 1 : -1;
            }
        });
        while (true) {
            String fileName = reader.readLine();
            if (fileNameOutput == null) {
                int posPoint = fileName.lastIndexOf(".");
                fileNameOutput = fileName.substring(0, posPoint);
            }
            if (fileName.equals("end")) break;
            set.add(fileName);
        }
        reader.close();
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameOutput);
        for (String s : set) {
            FileInputStream fileInputStream = new FileInputStream(s);
            byte[] b = new byte[fileInputStream.available()];
            fileInputStream.read(b);
            fileOutputStream.write(b);
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}