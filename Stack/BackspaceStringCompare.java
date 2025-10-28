class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> stackS = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stackS.push(c);
            } else if (!stackS.isEmpty()) {
                stackS.pop();
            }
        }

        Deque<Character> stackT = new ArrayDeque<>();
        for (char c : t.toCharArray()) {
            if (c != '#') {
                stackT.push(c);
            } else if (!stackT.isEmpty()) {
                stackT.pop();
            }
        }

        if (stackS.size() != stackT.size()) {
            return false;
        }

        while (!stackS.isEmpty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }

        return true;
    }
}