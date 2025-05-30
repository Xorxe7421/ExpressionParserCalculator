package ge.gpavl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class ExpressionParser {

    private static Map<String, List<String>> precedenceMap = Map.of(
            "+", List.of(),
            "-", List.of(),
            "*", List.of("+", "-"),
            "/", List.of("+", "-")
    );

    public static double parseExpression(List<String> tokens) {
        Deque<Double> operandStack = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.length() != 1 || Character.isDigit(token.charAt(0))) {
                operandStack.push(Double.parseDouble(token));
            }else {
                if (token.equals("(")) {
                    operatorStack.push(token);
                }else if (token.equals(")")) {
                    double result = combineOperands(operatorStack, operandStack);
                    operandStack.push(result);

                    if (!operatorStack.peek().equals("(")) {
                        result = combineOperands(operatorStack, operandStack);
                        operandStack.push(result);
                    }

                    operatorStack.pop();
                }else {
                    while (!operatorStack.isEmpty() && !precedenceMap.get(token).contains(operatorStack.peek()) && !operatorStack.peek().equals("(")) {
                        double result = combineOperands(operatorStack, operandStack);
                        operandStack.push(result);
                    }
                    operatorStack.push(token);
                }
            }
        }

        double result = combineOperands(operatorStack, operandStack);
        operandStack.push(result);

        if (!operatorStack.isEmpty()) {
            result = combineOperands(operatorStack, operandStack);
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    private static double combineOperands(Deque<String> operatorStack, Deque<Double> operandStack) {
        String operator = operatorStack.pop();
        double secondOperand = operandStack.pop();
        double firstOperand = operandStack.pop();

        return switch (operator) {
            case "+" -> firstOperand + secondOperand;
            case "-" -> firstOperand - secondOperand;
            case "*" -> firstOperand * secondOperand;
            case "/" -> firstOperand / secondOperand;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
