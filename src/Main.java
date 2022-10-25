import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int  []arabian = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    public static String []roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};

    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(calc(input));
        }
    }
    public static String calc(String input) throws Exception {
        String [] arabianTemp = {"10","1","2","3","4","5","6","7","8","9"};
        String [] romanTemp = {"X","I","II","III","IV","V","VI","VII","VIII","IX"};
        String [] operation = {"+","-","*","/"};

        String result = "";
        String[] subStr;
        String delimeter = " ";
        subStr = input.split(delimeter);

        if(Arrays.asList(arabianTemp).contains(subStr[0]) && Arrays.asList(operation).contains(subStr[1]) && Arrays.asList(arabianTemp).contains(subStr[2])){

            Integer a = Integer.valueOf(subStr[0]);
            Integer b = Integer.valueOf(subStr[2]);

            switch(subStr[1]) {
                case "+":
                    result = String.valueOf(a + b);
                    break;
                case "-":
                    result = String.valueOf(a - b);
                    break;
                case "*":
                    result = String.valueOf(a * b);
                    break;
                case "/":
                    result = String.valueOf(a / b);
                    break;
            }
        }

        else if(Arrays.asList(romanTemp).contains(subStr[0]) && Arrays.asList(operation).contains(subStr[1]) && Arrays.asList(romanTemp).contains(subStr[2])) {

            Integer a = Integer.valueOf(arabianTemp[Arrays.asList(romanTemp).indexOf(subStr[0])]);
            Integer b = Integer.valueOf(arabianTemp[Arrays.asList(romanTemp).indexOf(subStr[2])]);

            int tempResult = 0;

            switch (subStr[1]) {
                case "+":
                    tempResult = a + b;
                    break;
                case "-":
                    tempResult = a - b;

                    break;
                case "*":
                    tempResult = a * b;
                    break;
                case "/":
                    tempResult = a / b;
                    break;
            }
            if (tempResult > 0) {
                int i = 12;
                while (tempResult > 0) {
                    while (arabian[i] > tempResult) {
                        i--;
                    }
                    result += roman[i];
                    tempResult -= arabian[i];
                }
            } else {throw new Exception();}
        } else {throw new Exception();}

        return result;
    }

}
