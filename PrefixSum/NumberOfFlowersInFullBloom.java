class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;

        // Tách thành 2 mảng riêng biệt
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1];
        }

        // Sắp xếp cả 2 mảng
        Arrays.sort(starts);
        Arrays.sort(ends);

        int[] answer = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            int time = people[i];

            // Đếm số hoa đã nở (start <= time)
            int bloomed = countLessOrEqual(starts, time);

            // Đếm số hoa đã tàn (end < time)
            int withered = countLess(ends, time);

            // Số hoa đang nở = đã nở - đã tàn
            answer[i] = bloomed - withered;
        }

        return answer;
    }

    private int countLessOrEqual(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int countLess(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}