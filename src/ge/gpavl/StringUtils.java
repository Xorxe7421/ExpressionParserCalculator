package ge.gpavl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtils {

    public static String removeWhiteSpace(String userInput) {
        return userInput.replace(" ", "");
    }

    public static List<String> tokenizeInput(String cleanedUserInput) {
        String delimiters = "()+-*/";
        StringTokenizer stringTokenizer = new StringTokenizer(cleanedUserInput, delimiters, true);

        List<String> result = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            result.add(stringTokenizer.nextToken());
        }

        return result;
    }
}
