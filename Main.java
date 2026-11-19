import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoubleStack s = new DoubleStack();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String expr = keyboard.nextLine();

        String[] parts = expr.split(" ");
        for(String part : parts) {
            // Is part a number or an operator?
            if(isOperator(part)) {
                int value2 = s.pop();
                int value1 = s.pop();
                if(part.equals("+")) {
                    s.push(value1 + value2);
                } else if(part.equals("-")) {
                    s.push(value1 - value2);
                } else if(part.equals("*")) {
                    s.push(value1 * value2);
                } else if(part.equals("/")) {
                    s.push(value1 / value2);
                } else {
                    System.out.println("Unsupported operator: " + part);
                }                
            } else {
                try {
                    s.push(Integer.parseDouble(part));
                } catch(RuntimeException e) {
                    System.out.println("Malformed expression");
                }
            }
        }
        // Here, hthe result should be at the top of the stack.
        Double result = s.pop();
        System.out.println("The result is " + result);
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || 
            s.equals("*") || s.equals("/");
    }
}
