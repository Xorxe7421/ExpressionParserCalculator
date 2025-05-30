package ge.gpavl;

import java.util.Scanner;

public class IOUtils {

    public static String getUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void printResult(double result) {
        int integerResult = (int) result;

        if (result - integerResult == 0) {
            System.out.printf("Result: " + integerResult + "\n");
        }else {
            System.out.printf("Result: " + result + "\n");
        }
    }

    public static void printError(String message) {
        System.err.println(message);
    }
}
