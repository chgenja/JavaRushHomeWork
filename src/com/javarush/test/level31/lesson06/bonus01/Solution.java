package com.javarush.test.level31.lesson06.bonus01;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        String resultFileName = args[0];
        List<File> files = new ArrayList<>();
        for (int i = 1; i < args.length; i++)
            files.add(new File(args[i]));
        Collections.sort(files);

        byte[] data = new byte[1024];

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (File f: files) {
            FileInputStream fileInputStream = new FileInputStream(f);
            while (fileInputStream.read(data) > -1) {
                byteArrayOutputStream.write(data);
                byteArrayOutputStream.flush();
            }
        }

        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        FileOutputStream fileOutputStream = new FileOutputStream(resultFileName);
        ZipEntry ze = zipInputStream.getNextEntry();
        int count;
        while (ze!=null) {
            while ((count=zipInputStream.read(data))>-1) {
                fileOutputStream.write(data,0,count);
                fileOutputStream.flush();
            }
            ze = zipInputStream.getNextEntry();
        }
        zipInputStream.close();
        fileOutputStream.close();
        byteArrayOutputStream.close();
    }
}
