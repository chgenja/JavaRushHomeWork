package com.javarush.test.level15.lesson04.task02;

/* ООП - Перегрузка
Перегрузите метод printMatrix 8 различными способами. В итоге должно получиться 10 различных методов printMatrix.
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
    public static void printMatrix(byte a) {
        System.out.println("Перегрузка номер 3");
        printMatrix("str", (short) 1);
    }
    public static void printMatrix(String a, short b) {
        System.out.println("Перегрузка номер 4");
        printMatrix((byte) 1, "str");
    }
    public static void printMatrix(byte a, String b) {
        System.out.println("Перегрузка номер 5");
        printMatrix((Integer) 1, (short) 1);
    }
    public static void printMatrix(Integer a, short b) {
        System.out.println("Перегрузка номер 6");
        printMatrix((Double) 1.0, (short) 1);
    }
    public static void printMatrix(Double a, short b) {
        System.out.println("Перегрузка номер 7");
        printMatrix();
    }
    public static void printMatrix() {
        System.out.println("Перегрузка номер 8");
        printMatrix("str");
    }
    public static void printMatrix(String a) {
        System.out.println("Перегрузка номер 9");
        printMatrix((byte)1, (short)1);
    }
    public static void printMatrix(byte a, short b) {
        System.out.println("Перегрузка номер 10");
    }
}
