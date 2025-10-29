import java.util.*;

public class NumberOfStudentsUnableToEatLunch {
    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            Queue<Integer> studentQueue = new LinkedList<>();

            for (int student : students) {
                studentQueue.offer(student);
            }

            int i = 0; 
            int count = 0;

            while (!studentQueue.isEmpty() && count < studentQueue.size()) {
                int currentStudent = studentQueue.poll();
                if (currentStudent == sandwiches[i]) {
                    i++; 
                    count = 0; 
                } else {
                    studentQueue.offer(currentStudent);
                    count++; 
                }
            }

            return studentQueue.size();
        }
    }
}