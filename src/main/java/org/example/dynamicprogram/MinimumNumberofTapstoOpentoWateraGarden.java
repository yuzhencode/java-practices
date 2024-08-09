package org.example.dynamicprogram;

public class MinimumNumberofTapstoOpentoWateraGarden {
    public int minTaps(int n, int[] ranges) {
        // Create an array to hold the maximum reach for each point
        int[] maxReach = new int[n + 1];

        // Populate the maxReach array with the farthest reach of each tap
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            maxReach[start] = Math.max(maxReach[start], end);
        }

        int tapsOpened = 0;
        int currentEnd = 0;
        int farthestReach = 0;

        for (int i = 0; i <= n; i++) {
            if (i > farthestReach) {
                // If we are at a point that cannot be reached, return -1
                return -1;
            }

            // Update the farthest point we can reach at the current point
            farthestReach = Math.max(farthestReach, maxReach[i]);

            // If we reach the end of the current coverage, we need to open another tap
            if (i == currentEnd) {
                tapsOpened++;
                currentEnd = farthestReach;
            }

            // If we already cover the whole garden, we can return the result
            if (currentEnd >= n) {
                return tapsOpened;
            }
        }

        return currentEnd >= n ? tapsOpened : -1;
    }


    public static void main(String[] args) {
        MinimumNumberofTapstoOpentoWateraGarden solution = new MinimumNumberofTapstoOpentoWateraGarden();
        int n1 = 5;
        int[] ranges1 = {3, 4, 1, 1, 0, 0};
        System.out.println(solution.minTaps(n1, ranges1));  // Output: 1

        int n2 = 3;
        int[] ranges2 = {0, 0, 0, 0};
        System.out.println(solution.minTaps(n2, ranges2));  // Output: -1
    }
}
