package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        String s = "MARCH 1 2000";
        System.out.println(isDateOdd(s));
    }

    public static boolean isDateOdd(String date)
    {
        String month = "";
        int day = 0;
        boolean temp = false;
        int year = 0;
        int firstspaceindex = 0;
        for (int i = 0; i < date.length(); i++) {
            if (date.substring(i,i+1).equals(" ") && (temp == true))
            {
                day = Integer.parseInt(date.substring(firstspaceindex + 1, i));
                year = Integer.parseInt(date.substring(i+1));
                break;
            }
            if (date.substring(i,i+1).equals(" ") && (temp == false))
            {
                month = date.substring(0, i);
                temp = true;
                firstspaceindex = i;
            }


        }
        int monthdaynumber = 0;
        switch (month) {
            case "JANUARY": monthdaynumber = 0;
                break;
            case "FEBRUARY": monthdaynumber = 31;
                break;
            case "MARCH": monthdaynumber = 59;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
            case "APRIL": monthdaynumber = 90;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
            case "MAY": monthdaynumber = 120;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
            case "JUNE": monthdaynumber = 151;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
            case "JULY": monthdaynumber = 181;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
            case "AUGUST": monthdaynumber = 212;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
            case "SEPTEMBER": monthdaynumber = 243;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
            case "OCTOBER": monthdaynumber = 273;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
            case "NOVEMBER": monthdaynumber = 304;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
            case "DECEMBER": monthdaynumber = 334;
                if (year % 4 == 0) {
                    monthdaynumber++;
                }
                break;
        }

        if ((monthdaynumber + day) % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
