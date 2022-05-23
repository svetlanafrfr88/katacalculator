package calculator;

public class Calcul {

    private static int result=0;

    public static int calcul(int number1, int number2, char operation) {

        switch (operation) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                result = number1 / number2;
        }

        return result;
    }
}