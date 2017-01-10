package com.javarush.test.level34.lesson02.home01;

import java.util.ArrayList;
import java.util.List;

/* Рекурсия для мат.выражения
На вход подается строка - математическое выражение.
Выражение включает целые и дробные числа, скобки (), пробелы, знак отрицания -, возведение в степень ^, sin(x), cos(x), tan(x)
Для sin(x), cos(x), tan(x) выражение внутри скобок считать градусами, например, cos(3 + 19*3)=0.5
Степень задается так: a^(1+3) и так a^4, что эквивалентно a*a*a*a.
С помощью рекурсии вычислить выражение и количество математических операций. Вывести через пробел результат в консоль.
Результат выводить с точностью до двух знаков, для 0.33333 вывести 0.33, использовать стандартный принцип округления.
Не создавайте статические переменные и поля класса.
Не пишите косвенную рекурсию.
Пример, состоящий из операций sin * - + * +:
sin(2*(-5+1.5*4)+28)
Результат:
0.5 6
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "";
        s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recursion(s, 0);

        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recursion(s, 0);

        s = "0.305";
        System.out.print(s + " expected output 0.3 0 actually ");
        solution.recursion(s, 0);

        s = "0.3051";
        System.out.print(s + " expected output 0.31 0 actually ");
        solution.recursion(s, 0);

        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
        System.out.print(s + " expected output 12 8 actually ");
        solution.recursion(s, 0);

        s = "tan(44+sin(89-cos(180)^2))";
        System.out.print(s + " expected output 1 6 actually ");
        solution.recursion(s, 0);


        s = "-2+(-2+(-2)-2*(2+2))";
        System.out.print(s + " expected output -14 8 actually ");
        solution.recursion(s, 0);

        s = "sin(80+(2+(1+1))*(1+1)+2)";
        System.out.print(s + " expected output 1 7 actually ");
        solution.recursion(s, 0);

        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
        System.out.print(s + " expected output 6 11 actually ");
        solution.recursion(s, 0);

        s = "2^10+2^(5+5)";
        System.out.print(s + " expected output 2048 4 actually ");
        solution.recursion(s, 0);

        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
        System.out.print(s + " expected output 72.96 8 actually ");
        solution.recursion(s, 0);

        s = "0.000025+0.000012";
        System.out.print(s + " expected output 0 1 actually ");
        solution.recursion(s, 0);

        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
        System.out.print(s + " expected output -3 16 actually ");
        solution.recursion(s, 0);

        s = "cos(3 + 19*3)";
        System.out.print(s + " expected output 0.5 3 actually ");
        solution.recursion(s, 0);

        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
        System.out.print(s + " expected output 8302231.36 14 actually ");
        solution.recursion(s, 0);

        s = "(-1 + (-2))";
        System.out.print(s + " expected output -3 3 actually ");
        solution.recursion(s, 0);

        s = "-sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output -0.5 7 actually ");
        solution.recursion(s, 0);

        s = "sin(100)-sin(100)";
        System.out.print(s + " expected output 0 3 actually ");
        solution.recursion(s, 0);
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        //() expression
        String subexpression = "";

        int openBracketIndex = expression.lastIndexOf("(");
        int closeBracketIndex = expression.indexOf(")",openBracketIndex);
        if (openBracketIndex != -1) {
            subexpression = expression.substring(openBracketIndex+1,closeBracketIndex);
        } else subexpression = expression;
        subexpression.replaceAll(" ","");

        //lists of numbers and operations
        List<String> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();
        String number = "";

        for (int i = 0; i < subexpression.length(); i++) {
            char c = subexpression.charAt(i);
            if ((c >= '0' && c <= '9') || (c == '.')) {
                number += c;
                if (i == subexpression.length()-1)
                    numbers.add(number);
                continue;
            } else if ((c == '+') || (c == '*') || (c == '/') || (c == '^')) {
                operations.add(String.valueOf(c));
                if (number.length() != 0) {
                    numbers.add(number);
                    number = "";
                    continue;
                }
            } else if ((c == '-')) {
                if ((i!=0) && ((subexpression.charAt(i-1) == '+') || (subexpression.charAt(i-1) == '*') || (subexpression.charAt(i-1) == '/') || (subexpression.charAt(i-1) == '^') || (subexpression.charAt(i-1) == '-'))){
                    number += c;
                    countOperation++;
                    continue;
                } else if (i == 0) {
                    number += c;
                    countOperation++;
                    continue;
                } else {
                    operations.add(String.valueOf(c));
                    if (number.length() != 0) {
                        numbers.add(number);
                        number = "";
                        continue;
                    }
                }
            }
        }
        List<String> numbersClone = new ArrayList<>(numbers);

        double subExpressionResult = 0d;
        boolean firstMinus = (numbers.size() == operations.size());
        if ((operations.size() == 0) && (numbers.size() == 1) && (openBracketIndex == -1))  {
            if (numbers.get(0).charAt(0) == '-')
                countOperation--;
            System.out.println(Math.round(Double.parseDouble(numbers.get(0))*100)/100.0 + " " + countOperation);
            return;
        } else if (operations.size() == 0) {
            if (numbers.get(0).charAt(0) == '-')
                countOperation--;
            subExpressionResult += Math.round(Double.parseDouble(numbers.get(0))*100)/100.0;
        }
        while (operations.size()>0) {

            while (operations.contains("^")) {
                int indexOfMultiple = operations.indexOf("^");
                int firstNumberIndex;
                int secondNumberIndex;
                if (firstMinus) {
                    firstNumberIndex = indexOfMultiple - 1;
                    secondNumberIndex = indexOfMultiple;
                } else {
                    firstNumberIndex = indexOfMultiple;
                    secondNumberIndex = indexOfMultiple + 1;
                }

                String resultOfMultiple = String.valueOf(Math.pow(Double.parseDouble(numbers.get(firstNumberIndex)),Double.parseDouble(numbers.get(secondNumberIndex))));
                numbers.set(firstNumberIndex,resultOfMultiple);
                numbers.remove(secondNumberIndex);
                operations.remove(indexOfMultiple);
                countOperation++;
            }

            while (operations.contains("*") || operations.contains("/")) {
                for (int i = 0; i < operations.size(); i++) {
                    if (operations.get(i).equals("*")) {
                        int firstNumberIndex;
                        int secondNumberIndex;
                        if (firstMinus) {
                            firstNumberIndex = i - 1;
                            secondNumberIndex = i;
                        } else {
                            firstNumberIndex = i;
                            secondNumberIndex = i + 1;
                        }
                        String resultOfMultiple = String.valueOf(Double.parseDouble(numbers.get(firstNumberIndex)) * Double.parseDouble(numbers.get(secondNumberIndex)));
                        numbers.set(firstNumberIndex,resultOfMultiple);
                        numbers.remove(secondNumberIndex);
                        i--;
                        operations.remove(i+1);
                        countOperation++;
                    } else if (operations.get(i).equals("/")) {
                        int firstNumberIndex;
                        int secondNumberIndex;
                        if (firstMinus) {
                            firstNumberIndex = i - 1;
                            secondNumberIndex = i;
                        } else {
                            firstNumberIndex = i;
                            secondNumberIndex = i + 1;
                        }
                        String resultOfMultiple = String.valueOf(Double.parseDouble(numbers.get(firstNumberIndex)) / Double.parseDouble(numbers.get(secondNumberIndex)));
                        numbers.set(firstNumberIndex,resultOfMultiple);
                        numbers.remove(secondNumberIndex);
                        i--;
                        operations.remove(i+1);
                        countOperation++;

                    }
                }
            }

            if (firstMinus) {
                for (int i = 0; i < operations.size(); i++) {
                    if (operations.get(i).equals("+")) {
                        subExpressionResult += Double.parseDouble(numbers.get(i));
                        operations.remove(0);
                        numbers.remove(0);
                        i--;
                        countOperation++;

                    } else if (operations.get(i).equals("-")) {
                        subExpressionResult -= Double.parseDouble(numbers.get(i));
                        operations.remove(0);
                        numbers.remove(0);
                        i--;
                        countOperation++;

                    }
                }
            } else {
                subExpressionResult += Math.round(Double.parseDouble(numbers.get(0))*100)/100.0;
                while (operations.size() > 0) {
                    int secondNumberIndex = 1;
                    if (operations.get(0).equals("+")) {
                        if (numbers.get(secondNumberIndex).charAt(0) == '-')
                            countOperation--;
                        subExpressionResult += Math.round(Double.parseDouble(numbers.get(secondNumberIndex))*100)/100.0;
                        numbers.remove(secondNumberIndex);
                        operations.remove(0);
                        countOperation++;

                    } else if (operations.get(0).equals("-")) {
                        if (numbers.get(secondNumberIndex).charAt(0) == '-')
                            countOperation--;
                        subExpressionResult -= Math.round(Double.parseDouble(numbers.get(secondNumberIndex))*100)/100.0;
                        numbers.remove(secondNumberIndex);
                        operations.remove(0);
                        countOperation++;

                    }
                }

            }

        }
        boolean containsFunc = false;
        if (openBracketIndex >= 3) {
            String beforeBracket = expression.substring(openBracketIndex-3,openBracketIndex);
            switch (beforeBracket) {
                case ("sin"): {
                    subExpressionResult = Math.round(Math.sin(Math.toRadians(subExpressionResult))*100)/100.0;
                    containsFunc = true;
                    countOperation++;

                    break;
                }
                case ("cos"): {
                    subExpressionResult = Math.round(Math.cos(Math.toRadians(subExpressionResult))*100)/100.0;
                    containsFunc = true;
                    countOperation++;

                    break;
                }
                case ("tan"): {
                    subExpressionResult = Math.round(Math.tan(Math.toRadians(subExpressionResult))*100)/100.0;
                    containsFunc = true;
                    countOperation++;

                    break;
                }
                default: break;
            }
        }
        subExpressionResult = Math.round(subExpressionResult*100)/100.0;
        String newString = "";
        if (expression.contains("+") || expression.contains("-") || expression.contains("*") || expression.contains("/") || expression.contains("^") || expression.contains("sin") || expression.contains("cos") || expression.contains("tan")) {
            if (containsFunc) {
                newString = expression.substring(0, openBracketIndex - 3) + subExpressionResult + expression.substring(closeBracketIndex + 1);
            } else {
                if (openBracketIndex != -1) {
                    newString = expression.substring(0, openBracketIndex) + subExpressionResult + expression.substring(closeBracketIndex + 1);
                } else {
                    newString = String.valueOf(subExpressionResult);
                }
            }
/*
            for (int i = 0; i < numbersClone.size(); i++) {
                if (numbersClone.get(i).charAt(0) == '-')
                    countOperation++;
            }
*/
            recursion(newString, countOperation);

        } else System.out.println(Math.round(Double.parseDouble(expression)*100)/100.0 + " " + countOperation);




    }

    public Solution() {
        //don't delete
    }
}
