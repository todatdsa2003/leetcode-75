//Using name class Solution gives error on LeetCode
public class GuessNumberHigherOrLower extends GuessGame { 
    public int guessNumber(int n) {
        int left = 0;
        int right = n ;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        GuessNumberHigherOrLower solution = new GuessNumberHigherOrLower();
        int n = 10; 
        int result = solution.guessNumber(n);
        System.out.println("The guessed number is: " + result);
    }
}

class GuessGame {
    // Simple local stub so the code compiles; on LeetCode the platform provides the real implementation.
    // Modify this stub to simulate different secret numbers when testing locally.
    protected int guess(int num) {
        return 0;
    }
}
