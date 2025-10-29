import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    class Solution {
        //Using Queue
        public String predictPartyVictory(String senate) {
            Queue<Integer> radiantQueue = new LinkedList<>();
            Queue<Integer> direQueue = new LinkedList<>();
            int n = senate.length();

            for (int i = 0; i < n; i++) {
                if (senate.charAt(i) == 'R') {
                    radiantQueue.offer(i);
                } else {
                    direQueue.offer(i);
                }
            }

            while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
                int radiantIndex = radiantQueue.poll();
                int direIndex = direQueue.poll();

                if (radiantIndex < direIndex) {
                    radiantQueue.offer(radiantIndex + n);
                } else {
                    direQueue.offer(direIndex + n);
                }
            }

            return radiantQueue.isEmpty() ? "Dire" : "Radiant";
        }

        // public String predictPartyVictory(String senate) {
        //     int radiantCount = 0;
        //     int direCount = 0;

        //     for (char c : senate.toCharArray()) {
        //         if (c == 'R') {
        //             radiantCount++;
        //         } else {
        //             direCount++;
        //         }
        //     }

        //     return radiantCount > direCount ? "Radiant" : "Dire" ;
        // }
    }
}
