import java.util.ArrayList;

public class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort intervals based on starting time
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    // Swap intervals[i] and intervals[j]
                    int tempStart = intervals[i][0];
                    int tempEnd = intervals[i][1];
                    intervals[i][0] = intervals[j][0];
                    intervals[i][1] = intervals[j][1];
                    intervals[j][0] = tempStart;
                    intervals[j][1] = tempEnd;
                }
            }
        }

        // Step 2: Merge intervals
        ArrayList<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                // Overlapping, so merge
                end = Math.max(end, intervals[i][1]);
            } else {
                // No overlap, add previous interval to result
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add the last interval
        result.add(new int[]{start, end});

        // Convert ArrayList to 2D array
        int[][] merged = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            merged[i] = result.get(i);
        }

        return merged;
    }
}
