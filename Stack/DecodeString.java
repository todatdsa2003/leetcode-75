import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    class Solution {
        public String decodeString(String s) {
            Deque<Integer> countStack = new ArrayDeque<>();
            Deque<StringBuilder> stringStack = new ArrayDeque<>();
            StringBuilder currentString = new StringBuilder();
            int currentNum = 0;
            
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                
                if (Character.isDigit(c)) {
                    currentNum = currentNum * 10 + (c - '0');
                    
                } else if (c == '[') {
                    countStack.push(currentNum);
                    stringStack.push(currentString);
                    
                    currentString = new StringBuilder();
                    currentNum = 0;
                    
                } else if (c == ']') {
                    int repeatTimes = countStack.pop();
                    StringBuilder prevString = stringStack.pop();
                    String temp = currentString.toString();
                    for (int j = 0; j < repeatTimes; j++) {
                        prevString.append(temp);
                    }
                    
                    currentString = prevString;
                    
                } else {
                    currentString.append(c);
                }
            }
            
            return currentString.toString();
        }
    }
}
