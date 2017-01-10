package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution
{
    public static String getPartOfString(String string) throws TooShortStringException
    {

            if (string == null)
                throw new TooShortStringException();
            int firstTabIndex = string.indexOf("\t");
            if (firstTabIndex == -1)
                throw new TooShortStringException();

            int secondTabIndex = string.indexOf("\t", firstTabIndex + 1);
            if (secondTabIndex == -1)
                throw new TooShortStringException();

            return string.substring(firstTabIndex + 1, secondTabIndex).trim();

    }




    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
