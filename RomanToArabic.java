package calculator;

public class RomanToArabic {

    public static int rTA(String romans) {

        String [] roman = new String[] { "X", "IX", "VIII", "VII", "VI", "V", "IV", "III", "II", "I"};
        int [] arabic = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int result = 0;


        for (int i = 0; i<arabic.length; i++) {
            while (romans.indexOf(roman[i]) == 0) {
                result += arabic[i];
                romans = romans.substring(roman[i].length());
            }
        }
        return result;
    }
}
