package coursera.sandiego.basicdatastructures.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class MatchingWithMismatches {

  public List<Integer> solve(int k, String text, String pattern) {
    ArrayList<Integer> pos = new ArrayList<>();
    return pos;
  }

  public void run() {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    in.lines().forEach(line -> {
      StringTokenizer tok = new StringTokenizer(line);
      int k = Integer.valueOf(tok.nextToken());
      String s = tok.nextToken();
      String t = tok.nextToken();
      List<Integer> ans = solve(k, s, t);
      out.format("%d ", ans.size());
      out.println(ans.stream()
      .map(n -> String.valueOf(n))
      .collect(Collectors.joining(" "))
      );
    });
    out.close();
  }

  static public void main(String[] args) {
    new MatchingWithMismatches().run();
  }
}
