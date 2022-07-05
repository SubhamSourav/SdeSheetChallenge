import java.util.*;

class meeting {
    int start, end, pos;

    meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class _1maxMeetings {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        ArrayList<meeting> meet = new ArrayList<meeting>();

        for (int i = 0; i < start.length; i++) {
            meet.add(new meeting(start[i], end[i], i + 1));
        }

        Collections.sort(meet, (a, b) -> {
            if (a.end != b.end)
                return a.end - b.end;
            else
                return a.pos - b.pos;
        });

        for (meeting meeting : meet) {
            System.out.println(meeting.start + " " + meeting.end + " " + meeting.pos);
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int fin = meet.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > fin) {
                ans.add(meet.get(i).pos);
                fin = meet.get(i).end;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        System.out.println(maximumMeetings(start, end));
    }
}