public class FirstBadVersion {
    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isBadVersion(mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;

        }
    }
    public static void main(String[] args) {
        Solution solution = new FirstBadVersion().new Solution();
        int n = 5;
        int firstBad = solution.firstBadVersion(n);
        System.out.println("First bad version: " + firstBad);
    }

    class VersionControl {
        boolean isBadVersion(int version) {
            return true;
        }
    }
}
