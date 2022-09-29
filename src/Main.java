import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("Введите выражение арабскими или римскими цифрами:");
        String input = in.nextLine();
        if(input.length() < 2)
        {
            throw new IOException("Строка не является математической операцией");
        }
        System.out.println(calc(input));
    }

    public static String calc(String input) throws IOException {
        int toConvertNumber1, toConvertNumber2;
        char operation = 0;
        int result;
        char[] getUserInput = new char[10];
        for (int i = 0; i < input.length(); i++)
        {
            switch (input.charAt(i))
            {
                case '+' -> operation = '+';
                case '-' -> operation = '-';
                case '*' -> operation = '*';
                case '/' -> operation = '/';
            }
        }

        String[] symbols = input.split("[-+/*]");
        if(symbols.length > 2)
        {
            throw new IOException("Слишком много операторов(больше одного).");
        }
        String symbol1 = symbols[0].trim();
        String symbol2 = symbols[1].trim();

        toConvertNumber1 = romanToNumber(symbol1);
        toConvertNumber2 = romanToNumber(symbol2);


        if(toConvertNumber1 < 0 && toConvertNumber2 < 0)
        {
            result = 0;
        }
        else
        {
            result = calculated(toConvertNumber1, toConvertNumber2, operation);
            if(toConvertNumber1 < toConvertNumber2)
            {
                throw new IOException("В римской системе исчисления нет отрицательных чисел.");
            }
            String resultOut = convertNumToRoman(result);
            return resultOut;
        }

        toConvertNumber1 = Integer.parseInt(symbol1);
        toConvertNumber2 = Integer.parseInt(symbol2);
        result = calculated(toConvertNumber1, toConvertNumber2, operation);
        String resultOut = result + "";
        return resultOut;

    }

    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }
    public static int calculated (int num1, int num2, char op) throws IOException {
        int result = 0;
        if(!(num1 > 0 && num1 <= 10 && num2 > 0 && num2 <= 10))
        {
            throw new IOException("Вы ввели недопустимые значения");
        }
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Исключение : " + e);
                    System.out.println("Допускаются только целочисленные ненулевые параметры");
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }
        return result;
    }

}

