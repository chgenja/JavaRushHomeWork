package com.javarush.test.level22.lesson13.task01;

import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter)
    {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        String[] result = new String[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens())
        {
            result[i] = tokenizer.nextToken();
            i++;
        }
        return result;
    }

    public static void main(String[] args)
    {
        String query = "level22.lesson13.task01";
        String delimiter = ".";
        String[] result = getTokens(query,delimiter);
        System.out.println(Arrays.toString(result));
    }
}
