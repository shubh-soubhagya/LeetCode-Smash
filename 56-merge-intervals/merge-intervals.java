import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        // Take the first interval as current
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // If overlapping
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);  // merge
            } else {
                result.add(current);
                current = next;  // move to next interval
            }
        }

        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
