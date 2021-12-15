/**
 * This class checks if the delimiters match using a stack.
 * @author Seth Brown
 * @version 15 Dec 2021
 */

public class DelimiterMatching {
    public static void main(String[] args) {

        String inputOne = "a{b(c]d}e";
        String inputTwo = "[a{b(c)d}e]";
        System.out.println(check(inputOne));
        System.out.println("BREAK FOR INPUT TWO");
        System.out.println(check(inputTwo));

    }

    public static boolean check(String input) {
        int stackSize = input.length();
        Stack<String> theStack = new Stack<String>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    theStack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!theStack.isEmpty()) {
                        char chx = theStack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + i);
                            return false;
                        }
                    }
                    else {
                        System.out.println("Error: " + ch + " at " + i);
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (!theStack.isEmpty()) {
            System.out.println("Error: missing right delimiter ");
            return false;
        }
        return true;
    }


}