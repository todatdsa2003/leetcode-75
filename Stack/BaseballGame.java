class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : operations) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;

                case "D":
                    stack.push(stack.peek() * 2);
                    break;

                case "+":
                    int top = stack.pop();
                    int secondTop = stack.peek();
                    stack.push(top);
                    stack.push(top + secondTop);
                    break;

                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}