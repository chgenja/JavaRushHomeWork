package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.AA);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.AA, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.BB);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.BB, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.CC);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.CC, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.DD);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.DD, cause);
        }
    }

    public static final class Constants
    {
        public static final String AA = "Server is not accessible for now.";
        public static final String BB = "User is not authorized.";
        public static final String CC = "User is banned.";
        public static final String DD = "Access is denied.";
    }
}
