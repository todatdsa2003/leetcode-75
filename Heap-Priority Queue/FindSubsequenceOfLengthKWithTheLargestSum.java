class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        //Using Min Heap
        int n = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        for (int i = 0; i < n; i++) {
            minHeap.offer(i);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> indices = new ArrayList<>(minHeap);
        Collections.sort(indices);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[indices.get(i)];
        }

        return result;
        //Using MAx Heap
        // int n = nums.length;
        // PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // for (int i = 0; i < n; i++) {
        //     maxHeap.offer(new int[] { nums[i], i });
        // }
        // List<int[]> topK = new ArrayList<>();
        // for (int i = 0; i < k; i++) {
        //     topK.add(maxHeap.poll());
        // }

        // topK.sort((a, b) -> a[1] - b[1]);

        // int[] result = new int[k];
        // for (int i = 0; i < k; i++) {
        //     result[i] = topK.get(i)[0];
        // }

        // return result;
        //Sap xep don gian
        //     int n = nums.length;

        //     int[][] valueIndex = new int[n][2];
        //     for (int i = 0; i < n; i++) {
        //         valueIndex[i][0] = nums[i]; 
        //         valueIndex[i][1] = i;
        //     }

        //     Arrays.sort(valueIndex, (a, b) -> b[0] - a[0]);

        //     int[][] topK = new int[k][2];
        //     for (int i = 0; i < k; i++) {
        //         topK[i][0] = valueIndex[i][0]; 
        //         topK[i][1] = valueIndex[i][1]; 
        //     }

        //     Arrays.sort(topK, (a, b) -> a[1] - b[1]);

        //     int[] result = new int[k];
        //     for (int i = 0; i < k; i++) {
        //         result[i] = topK[i][0];
        //     }

        //     return result;
    }
}