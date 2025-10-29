//Da tham khao de toi uu code
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int number = 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(number);
                } else if (operation == '-') {
                    stack.push(-number);
                } else if (operation == '*') {
                    stack.push(stack.pop() * number);
                } else if (operation == '/') {
                    stack.push(stack.pop() / number);
                }

                operation = c;
                number = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}