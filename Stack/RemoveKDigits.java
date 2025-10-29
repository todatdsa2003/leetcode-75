class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(c);
        }

        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder result = new StringBuilder();
        boolean check = true;
        for (char c : stack) {
            if (check && c == '0') {
                continue;
            }
            check = false;
            result.append(c);
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    // Cach tham khao
    // public String removeKdigits(String num, int k) {
    // if (num.length() == k)
    // return "0";

    // StringBuilder stack = new StringBuilder();

    // for (char c : num.toCharArray()) {
    // while (k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > c) {
    // stack.deleteCharAt(stack.length() - 1);
    // k--;
    // }
    // stack.append(c);
    // }

    // stack.setLength(stack.length() - k);

    // int i = 0;
    // while (i < stack.length() && stack.charAt(i) == '0'){
    // i++;
    // }
    // String result = stack.substring(i);
    // return result.isEmpty() ? "0" : result;
    // }
}