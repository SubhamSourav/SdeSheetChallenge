import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval {
    int start;
    int finish;

    Interval(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class _2mergeOverlappingSubIntervals {

    public static List<Interval> mergeIntervals(Interval[] intervals) {

        List<Interval> ans = new ArrayList<Interval>();

        if (intervals.length == 1) {
        }

        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        int a = intervals[0].start;
        int b = intervals[0].finish;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start <= b) {
                b = Math.max(b, intervals[i].finish);
            } else {
                ans.add(new Interval(a, b));
                a = intervals[i].start;
                b = intervals[i].finish;
            }
        }
        ans.add(new Interval(a, b));
        return ans;
    }
}
