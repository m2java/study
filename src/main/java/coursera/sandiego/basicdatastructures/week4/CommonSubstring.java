package coursera.sandiego.basicdatastructures.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CommonSubstring {
  public class Answer {
    int i, j, len;

    Answer(int i, int j, int len) {
      this.i = i;
      this.j = j;
      this.len = len;
    }
  }

  public Answer solve(String s, String t) {
    Answer ans = new Answer(0, 0, 0);
    HashMap<String, Integer> maxMap = new HashMap<>();
    String min, max;
    if (s.length() <= t.length()) {
      min = s;
      max = t;
    } else {
      min = t;
      max = s;
    }
    int low = 1;
    int high = min.length();
    while (low != high) {
      int mid = ((high - low) >>> 1) + low;
      maxMap.clear();
      for (int i = 0; i < max.length() - mid + 1; ++i) {
        maxMap.put(max.substring(i, i + mid), i);
      }
      boolean found = false;
      for (int j = 0; j < min.length() - mid + 1; ++j) {
        Integer index = maxMap.get(min.substring(j, j + mid));
        if (index != null) {
          ans = new Answer(j, index, mid);
          found = true;
          break;
        }
      }
      if (found) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return ans;
  }

  public void run() {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    String line = null;
    try {
      line = in.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    StringTokenizer tok = new StringTokenizer(line);
    String s = tok.nextToken();
    String t = tok.nextToken();
    Answer ans = solve(s, t);
    out.format("%d %d %d\n", ans.i, ans.j, ans.len);

    out.close();
  }

  static public void main(String[] args) {
    new CommonSubstring().run();
  }
}
