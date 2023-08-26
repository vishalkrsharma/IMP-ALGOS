import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {

  static class Meeting {
    int start;
    int end;
    int pos;

    Meeting(int start, int end, int pos) {
      this.start = start;
      this.end = end;
      this.pos = pos;
    }
  }

  static class MeetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting o1, Meeting o2) {
      if (o1.end < o2.end)
        return -1;
      else if (o1.end > o2.end)
        return 1;
      else if (o1.pos < o2.pos)
        return -1;
      return 1;
    }
  }

  public static int maxMeetings(int start[], int end[], int n) {
    ArrayList<Meeting> meet = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      meet.add(new Meeting(start[i], end[i], i + 1));
    }

    MeetingComparator mc = new MeetingComparator();
    Collections.sort(meet, mc);
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(meet.get(0).pos);

    int limit = meet.get(0).end;

    for (int i = 1; i < n; i++) {
      if (meet.get(i).start > limit) {
        ans.add(meet.get(i).pos);
        limit = meet.get(i).end;
      }
    }

    return ans.size();
  }
}
