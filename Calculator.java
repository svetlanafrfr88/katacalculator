package calculator;

import java.util.Scanner;
import static calculator.Calcul.*;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1;
    static int number2;
    static char operation;
    static int result;
    private static boolean arabicNumber = true;

    public static void main(String[] args) throws Exception {
        System.out.println("Данный калькулятор работает с арабскими и римскими числами от 1 до 10. Введите выражение в виде 1+1 затем Enter.");
        String userInput = scanner.nextLine();

        char[] under_char = new char[10];

        if (userInput.length() > 2) {

            for (int i = 0; i < userInput.length(); i++) {
                under_char[i] = userInput.charAt(i);
                if (under_char[i] == '+') {
                    operation = '+';
                }
                if (under_char[i] == '-') {
                    operation = '-';
                }
                if (under_char[i] == '*') {
                    operation = '*';
                }
                if (under_char[i] == '/') {
                    operation = '/';
                }
            }
        } else throw new Exception ("формат введенных данных не удовлетворяет заданию");

        String under_charString = String.valueOf(under_char);
        String[] blocks = under_charString.split("[+-/*]");
        String stable00 = blocks[0];
        String stable01 = blocks[1];
        String string03 = stable01.trim();

        try {
            number1 = Integer.parseInt(stable00);
            number2 = Integer.parseInt(string03);

            if ((number1 < 0 || number1 > 10) || (number2 < 0 || number2 > 10)) {
                throw new Exception("На ввод принимаются только числа от 1 до 10");
            } else {
                result = calcul(number1, number2, operation);
                System.out.println("Ответ: " + result);
            }
        } catch (NumberFormatException e) {
            arabicNumber = false;

            number1 = RomanToArabic.rTA(stable00);
            number2 = RomanToArabic.rTA(string03);
            if ((number1 < 0 || number1 > 10) || (number2 < 0 || number2 > 10)) {
                throw new Exception("На ввод принимаются только числа от 1 до 10");
            } else {
                result = calcul(number1, number2, operation);
                if (result < 1) {
                    throw new Exception("в римской системе нет отрицательных чисел");
                } else {
                    System.out.println("Ответ: " + ArabicToRoman.aTR(result));}
            }
        }
    }
}