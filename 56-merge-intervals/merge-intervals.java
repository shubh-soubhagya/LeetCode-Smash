import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;

        // Sort by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (prev[1] >= curr[0]) {
                // merge
                prev = new int[]{prev[0], Math.max(prev[1], curr[1])};
            } else {
                result.add(prev);
                prev = curr;
            }
        }

        result.add(prev);

        return result.toArray(new int[result.size()][]);
    }
}
