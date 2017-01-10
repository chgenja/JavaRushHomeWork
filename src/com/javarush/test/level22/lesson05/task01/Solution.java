package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws TooShortStringException
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис"));
    }
    public static String getPartOfString(String string) throws TooShortStringException
    {
            if (string == null)
                throw new TooShortStringException();
            int[] indexes = new int[5];

            for (int i = 0; i < 5; i++)
            {

                int spaceIndex;
                if (i != 0)
                    spaceIndex = string.indexOf(" ",indexes[i-1]+1);
                else spaceIndex = string.indexOf(" ");
                if ((spaceIndex == -1) && (i !=4))
                    throw new TooShortStringException();
                else if ((spaceIndex == -1))
                    indexes[i] = string.length();
                else
                {
                    indexes[i] = spaceIndex;
                }
            }
            return string.substring(indexes[0]+1,indexes[indexes.length-1]);


    }

    public static class TooShortStringException extends Exception {
        public TooShortStringException()
        {
            super();
        }

        public TooShortStringException(String message)
        {
            super(message);
        }

        public TooShortStringException(String message, Throwable cause)
        {
            super(message, cause);
        }

        public TooShortStringException(Throwable cause)
        {
            super(cause);
        }

        protected TooShortStringException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
        {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
