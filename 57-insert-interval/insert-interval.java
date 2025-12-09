import java.util.*;

public class Interval {
    int start, end;

    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        Interval newInt = new Interval(newInterval[0], newInterval[1]);

        ArrayList<Interval> result = new ArrayList<>();

        for (int[] arr : intervals) {
            Interval interval = new Interval(arr[0], arr[1]);

            if (interval.end < newInt.start) {
                result.add(interval);
            } else if (interval.start > newInt.end) {
                result.add(newInt);
                newInt = interval;
            } else {
                newInt = new Interval(
                        Math.min(interval.start, newInt.start),
                        Math.max(interval.end, newInt.end)
                );
            }
        }

        result.add(newInt);

        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).start;
            ans[i][1] = result.get(i).end;
        }

        return ans;
    }
}
