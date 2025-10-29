class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] check = new boolean[26];
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            count[i]--;
            if (check[i]) {
                continue;
            }
            while (!deque.isEmpty() &&
                    deque.peekLast() > c &&
                    count[deque.peekLast() - 'a'] > 0) {
                char removed = deque.pollLast();
                check[removed - 'a'] = false;
            }

            deque.offerLast(c);
            check[i] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char c : deque) {
            result.append(c);
        }
        return result.toString();

        // Cach 2: Toi uu dung StringBuilder nhu stack
        // Dem so lan xuat hien cua tung ky tu
        // int[] count = new int[26];
        // for (char c : s.toCharArray()) {
        // count[c - 'a']++;
        // }

        // // Array de kiem tra ky tu da co trong stack chua
        // boolean[] inStack = new boolean[26];

        // // StringBuilder hoat dong nhu stack
        // StringBuilder stack = new StringBuilder();

        // // Duyet tung ky tu
        // for (char c : s.toCharArray()) {
        // int i = c - 'a';
        // count[i]--;
        // if (inStack[i]) {
        // continue;
        // }
        // // Kiem tra va loai bo cac ky tu o dinh stack
        // // Constraints:
        // // 1. stack khong null
        // // 2. dinh stack > c
        // // 3. con lai trong chuoi van con ky tu dinh stack
        // while (stack.length() > 0 &&
        // stack.charAt(stack.length() - 1) > c &&
        // count[stack.charAt(stack.length() - 1) - 'a'] > 0) {
        // char removed = stack.charAt(stack.length() - 1);
        // stack.deleteCharAt(stack.length() - 1);
        // inStack[removed - 'a'] = false;
        // }
        // stack.append(c);
        // inStack[i] = true;
        // }

        // return stack.toString();
    }
}