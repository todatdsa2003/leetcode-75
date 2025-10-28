
import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {
    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> result = new ArrayList<>();
            int currentNumber = 1;
            for (int number : target) {
                while (currentNumber < number) {
                    result.add("Push");
                    result.add("Pop");
                    currentNumber++;
                }
                result.add("Push");
                currentNumber++;
            }
            return result;
        }
    }
}
