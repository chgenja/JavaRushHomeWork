package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws IOException
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();

        Properties p = new Properties();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"));
        p.load(fileReader);
        fileReader.close();

        Enumeration e = p.propertyNames();
        while (e.hasMoreElements())
        {
            String key = (String) e.nextElement();
            properties.put(key,p.getProperty(key));
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println(properties.size());
        for (Map.Entry<String, String> pair : properties.entrySet())
        {
            printWriter.println(pair.getKey());
            printWriter.println(pair.getValue());
        }
        printWriter.flush();
        printWriter.close();
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++)
        {
            String key = reader.readLine();
            String value = reader.readLine();
            properties.put(key,value);
        }
        reader.close();
    }
}
