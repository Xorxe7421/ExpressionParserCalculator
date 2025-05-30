package ge.gpavl;

import java.util.List;

import static ge.gpavl.ExpressionParser.parseExpression;
import static ge.gpavl.IOUtils.*;
import static ge.gpavl.StringUtils.removeWhiteSpace;
import static ge.gpavl.StringUtils.tokenizeInput;

public class Main {
    public static void main(String[] args) {
        String userInput = getUserInput("Enter the expression: ");
        String cleanedUserInput = removeWhiteSpace(userInput);
        List<String> tokenizedInput = tokenizeInput(cleanedUserInput);
        try {
            double result = parseExpression(tokenizedInput);
            printResult(result);
        }catch (Exception e) {
            printError("Invalid format");
        }
    }
}