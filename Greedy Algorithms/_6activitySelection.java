import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Activity {
    int start, end;

    Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class _6activitySelection {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < start.size(); i++) {
            activities.add(new Activity(start.get(i), end.get(i)));
        }

        Collections.sort(activities, (a, b) -> a.end - b.end);

        int c = 1;
        int fin = activities.get(0).end;

        for (int i = 1; i < start.size(); i++) {
            if (activities.get(i).start >= fin) {
                fin = activities.get(i).end;
                c++;
            }
        }

        return c;

    }
}
