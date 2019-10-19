package coursera.sandiego.basicdatastructures.week4;

import java.util.*;
import java.io.*;

public class SubstringEquality {
  public class Solver {
    private String s;
    private long leftLimit = 1L;
    private long rightLimit = 1000_000_000L;
    private int m1 = 1000_000_007;
    private int m2 = 1000_000_009;
    private long x = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));

    public Solver(String s) {
      this.s = s;
    }

    public boolean ask(int a, int b, int l) {
      return hashFunc(s.substring(a, a + l), m1) == hashFunc(s.substring(b, b + l), m1) && hashFunc(s.substring(a, a + l), m2) == hashFunc(s.substring(b, b + l), m2);
    }


    public long hashFunc(String s, int m) {
      long hash = 0L;
      for (int i = s.length() - 1; i >= 0; --i) {
        hash = (hash * x + s.charAt(i)) % m;
      }
      return hash;
    }
  }

  public void run() throws IOException {
    FastScanner in = new FastScanner();
    PrintWriter out = new PrintWriter(System.out);
    String s = in.next();
    int q = in.nextInt();
    Solver solver = new Solver(s);
    for (int i = 0; i < q; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      int l = in.nextInt();
      out.println(solver.ask(a, b, l) ? "Yes" : "No");
    }
    out.close();
  }

  static public void main(String[] args) throws IOException {
    new SubstringEquality().run();
  }

  class FastScanner {
    StringTokenizer tok = new StringTokenizer("");
    BufferedReader in;

    FastScanner() {
      in = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
      while (!tok.hasMoreElements())
        tok = new StringTokenizer(in.readLine());
      return tok.nextToken();
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }
  }
}