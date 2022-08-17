package MyCalc;

import java.util.Arrays;
import java.util.Scanner;

public class KataTestCalc {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение: 'пример: 2 + 2'");
        String console = scanner.nextLine();
        System.out.println(calc(console));
    }

    public static String calc(String console) {

        int number1;
        int number2;
        int result;
        String answer;
        String rimResult;

        String[] value = console.split(" ");

        if (value.length <= 1) throw new RuntimeException("Строка не является математической операцией");
        if (value.length > 3)
            throw new RuntimeException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        String num1 = value[0];
        String operation = value[1];
        String num2 = value[2];

        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] rim = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        if ((Arrays.asList(arab).contains(num1)) && (Arrays.asList(arab).contains(num2)) || (Arrays.asList(rim).contains(num1)) && (Arrays.asList(rim).contains(num2)) ||
                (Arrays.asList(rim).contains(num1)) && (Arrays.asList(arab).contains(num2)) || (Arrays.asList(arab).contains(num1)) && (Arrays.asList(rim).contains(num2))) {

            if ((Arrays.asList(arab).contains(num1)) && (Arrays.asList(arab).contains(num2))) {
                number1 = convertArab(num1);
                number2 = convertArab(num2);
                result = getResult(number1, operation, number2);
                answer = String.valueOf(result);
            } else if ((Arrays.asList(rim).contains(num1)) && (Arrays.asList(rim).contains(num2))) {
                number1 = convertRim(num1);
                number2 = convertRim(num2);
                result = getRimResult(number1, operation, number2);
                rimResult = convert(result);
                if (result > 0) answer = rimResult;
                else
                    throw new RuntimeException("Результатом работы калькулятора с римскими числами могут быть только положительные числа");
            } else throw new RuntimeException("Используются одновременно разные системы счисления");
        } else
            throw new RuntimeException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");

        return answer;
    }

    static int getResult(int num1, String operation, int num2) {
        int result;
        if (operation.equals("+")) {
            result = num1 + num2;
            return result;
        }
        if (operation.equals("-")) {
            result = num1 - num2;
            return result;
        }
        if (operation.equals("*")) {
            result = num1 * num2;
            return result;
        }
        if (operation.equals("/")) {
            result = num1 / num2;
            return result;
        } else throw new RuntimeException("Знак операции не распознан");

    }

    static int getRimResult(int num1, String operation, int num2) {
        int result;
        if (operation.equals("+")) {
            result = num1 + num2;
            return result;
        }
        if (operation.equals("-")) {
            result = num1 - num2;
            if (result < 0) throw new RuntimeException("В римской системе нет отрицательных чисел");
            return result;
        }
        if (operation.equals("*")) {
            result = num1 * num2;
            return result;
        }
        if (operation.equals("/")) {
            result = num1 / num2;
            return result;
        } else throw new RuntimeException("Знак операции не распознан");

    }

    static int convertArab(String num) {
        if (num.equals("1")) return 1;
        if (num.equals("2")) return 2;
        if (num.equals("3")) return 3;
        if (num.equals("4")) return 4;
        if (num.equals("5")) return 5;
        if (num.equals("6")) return 6;
        if (num.equals("7")) return 7;
        if (num.equals("8")) return 8;
        if (num.equals("9")) return 9;
        if (num.equals("10")) return 10;
        return 0;
    }

    static int convertRim(String rim) {
        if (rim.equals("I")) return 1;
        if (rim.equals("II")) return 2;
        if (rim.equals("III")) return 3;
        if (rim.equals("IV")) return 4;
        if (rim.equals("V")) return 5;
        if (rim.equals("VI")) return 6;
        if (rim.equals("VII")) return 7;
        if (rim.equals("VIII")) return 8;
        if (rim.equals("IX")) return 9;
        if (rim.equals("X")) return 10;
        return 0;
    }

    static String convert(int getRimResult) {
        String convert;
        String[] rimNum = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI"};

        convert = rimNum[getRimResult];
        return convert;
    }

}

