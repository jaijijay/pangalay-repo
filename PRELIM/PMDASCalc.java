import java.util.Stack;
import java.util.Scanner;

public class PMDASCalc {
    public static int getPrecedence(char operator) {
        if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else {
            return 0;
        }
    }

    public static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            default:
                return 0;
        }
    }

    public static double evaluateEquation(String equation) {
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < equation.length(); i++) {
            char currentChar = equation.charAt(i);

            if (Character.isDigit(currentChar) || currentChar == '-') {
                StringBuilder operand = new StringBuilder();
                int j = i;

                
                if (currentChar == '-') {
                    operand.append(currentChar);
                    j++;
                }

                
                while (j < equation.length() && (Character.isDigit(equation.charAt(j)) || equation.charAt(j) == '.')) {
                    operand.append(equation.charAt(j));
                    j++;
                }

                double parsedOperand = Double.parseDouble(operand.toString());
                operandStack.push(parsedOperand);
                i = j - 1;  
            } else if (currentChar == '(') {
                operatorStack.push(currentChar);
            } else if (currentChar == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    double operand2 = operandStack.pop();
                    double operand1 = operandStack.pop();
                    char operator = operatorStack.pop();
                    double result = performOperation(operand1, operand2, operator);
                    operandStack.push(result);
                }

                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            } else {
                while (!operatorStack.isEmpty() && getPrecedence(currentChar) <= getPrecedence(operatorStack.peek())) {
                    double operand2 = operandStack.pop();
                    double operand1 = operandStack.pop();
                    char operator = operatorStack.pop();
                    double result = performOperation(operand1, operand2, operator);
                    operandStack.push(result);
                }
                operatorStack.push(currentChar);
            }
        }

        while (!operatorStack.isEmpty()) {
            double operand2 = operandStack.pop();
            double operand1 = operandStack.pop();
            char operator = operatorStack.pop();
            double result = performOperation(operand1, operand2, operator);
            operandStack.push(result);
        }

        return operandStack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an equation: ");
        String equation = scanner.nextLine();
        scanner.close();
        
        double result = evaluateEquation(equation);
        System.out.println("Result: " + result);
    }
}