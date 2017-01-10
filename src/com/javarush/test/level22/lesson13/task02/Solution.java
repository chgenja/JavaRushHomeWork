package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String filename1 = args[0];
        String filename2 = args[1];

        FileInputStream inputStream = new FileInputStream(new File(filename1));
        FileOutputStream outputStream = new FileOutputStream(new File(filename2));

        Charset Win1251 = Charset.forName("Windows-1251");
        Charset UTF = Charset.forName("UTF-8");


        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String s = new String(buffer,UTF);
        buffer = s.getBytes(Win1251);
        outputStream.write(buffer);


        inputStream.close();
        outputStream.close();
    }
}
