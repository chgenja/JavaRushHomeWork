package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution
{
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                String filename = reader.readLine();
                if (filename.equals("exit"))
                    break;
                new ReadThread(filename);
            }
            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread
    {
        public ReadThread(String fileName)
        {
            //implement constructor body
            run(fileName);
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run(String fileName)
        {
            try
            {
                FileInputStream inputStream = new FileInputStream(fileName);
                HashMap<Integer, Integer> byteCount = new HashMap<>();
                int maxValue = 0;
                while (inputStream.available() > 0)
                {
                    Integer byteSymbol = inputStream.read();
                    if (byteCount.containsKey(byteSymbol))
                    {
                        byteCount.put(byteSymbol, byteCount.get(byteSymbol) + 1);
                    } else
                    {
                        byteCount.put(byteSymbol, 1);
                    }
                    if (byteCount.get(byteSymbol) > maxValue)
                        maxValue = byteCount.get(byteSymbol);
                }
                inputStream.close();
                for (Map.Entry<Integer, Integer> pair : byteCount.entrySet())
                {
                    if (pair.getValue() == maxValue)
                    {
                        resultMap.put(fileName, pair.getKey());
                        break;
                    }
                }

            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }
}
