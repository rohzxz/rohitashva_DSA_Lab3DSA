
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    // Function to check if the input string contains balanced brackets
    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>(); // Create a stack to store opening brackets

        // Loop through each character in the input string
        for (char character : input.toCharArray()) {
            if (character == '(' || character == '[' || character == '{') {
                // If an opening bracket is encountered, push it onto the stack
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                // If a closing bracket is encountered
                if (stack.isEmpty()) {
                    // If the stack is empty, there is no matching opening bracket, so the string is
                    // unbalanced
                    return false;
                }
                char top = stack.pop(); // Pop the top element from the stack

                // Check if the closing bracket matches the last encountered opening bracket
                if ((character == ')' && top != '(') || (character == ']' && top != '[')
                        || (character == '}' && top != '{')) {
                    return false; // Mismatched brackets, so the string is unbalanced
                }
            }
        }

        // If the stack is empty at the end of the loop, all brackets are balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        scanner.close();

        if (isBalanced(userInput)) {
            System.out.println("The entered String has Balanced Brackets");
        } else {
            System.out.println("The entered String does not contain Balanced Brackets");
        }
    }
}
