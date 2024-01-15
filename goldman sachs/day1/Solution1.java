package day1;

import java.util.*;

public class Solution1 {
    private PriorityQueue<Integer> pq;  // Declare as an instance variable

    public Solution1() {
        pq = new PriorityQueue<>(Collections.reverseOrder());
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int i = 0, j = 0;
        int x1 = 1, x2 = 1;

        while (i < uniqueCnt1 || j < uniqueCnt2) {
            int candidate = Math.min(x1 * divisor1, x2 * divisor2);

            if (i < uniqueCnt1 && candidate > x1 && !pq.contains(candidate)) {
                pq.add(candidate);
                i++;
                x1 = candidate + 1;
            }

            if (j < uniqueCnt2 && candidate > x2 && !pq.contains(candidate)) {
                pq.add(candidate);
                j++;
                x2 = candidate + 1;
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int result = solution.minimizeSet(12, 3, 2, 10);
        System.out.println("Minimum Maximum: " + result);

        System.out.println("Priority Queue Elements:");
        for (int num : solution.getPq()) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public PriorityQueue<Integer> getPq() {
        return pq;
    }
}
