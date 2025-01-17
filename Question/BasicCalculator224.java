package Question;

import java.util.Stack;

public class BasicCalculator224 {
    static int i = 0;
    static int evaluate(String expression) {
        // Remove all whitespaces
        expression = expression.replaceAll("\\s", "");

        int result = 0;
        int currentNumber = 0;
        char operation = '+'; // Start with an initial operation as addition

        while(i < expression.length()) {
            char currentChar = expression.charAt(i);

            if(currentChar == ')'){
                if (operation == '+') {
                    result += currentNumber;
                } else if (operation == '-') {
                    result -= currentNumber;
                }
                return result;
            }

            // If current character is a digit, form the number
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }

            // If current character is an operator or end of string, calculate the result
            if (!Character.isDigit(currentChar) || i == expression.length() - 1) {
                if(currentChar == '('){
                    i++;
                    if (operation == '+') {
                        result += evaluate(expression);
                    } else if (operation == '-') {
                        result -= evaluate(expression);
                    }
                }
                else if (operation == '+') {
                    result += currentNumber;
                } else if (operation == '-') {
                    result -= currentNumber;
                }

                // Update the operation and reset the current number
                operation = currentChar;
                currentNumber = 0;
            }
            i++;
        }
        return result;
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        String expression1 = "1 + 3 + 4 - 2";
        String expression2 = "4+2-(3+1)";
        String expression3 = "(1+(4+5+2)-3)+(6+8)";
        int result = evaluate(expression3);
        System.out.println("The result is: " + result);
    }
}
