package ge.gpavl;

import java.util.Scanner;

public class IOUtils {

    public static String getUserInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
