package coursera.sandiego.basicdatastructures.week4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

  private static FastScanner in;
  private static PrintWriter out;

  public static void main(String[] args) throws IOException {
    in = new FastScanner();
    out = new PrintWriter(new BufferedOutputStream(System.out));
    printOccurrences(getOccurrences(readInput()));
    out.close();
  }

  private static Data readInput() throws IOException {
    String pattern = in.next();
    String text = in.next();
    return new Data(pattern, text);
  }

  private static void printOccurrences(List<Integer> ans) throws IOException {
    for (Integer cur : ans) {
      out.print(cur);
      out.print(" ");
    }
  }

  private static List<Integer> getOccurrences(Data input) {
    List<Integer> occurrences = new ArrayList<Integer>();
    String p = input.pattern, t = input.text;
    int patternHash = p.hashCode();
    int window = p.length();
    for (int i = 0; i < t.length() - window + 1; ++i) {
      String substring = t.substring(i, i + window);
      if (substring.hashCode() == patternHash) {
        if (substring.equals(p)) {
          occurrences.add(i);
        }
      }
    }
    return occurrences;
  }

  static class Data {
    String pattern;
    String text;

    public Data(String pattern, String text) {
      this.pattern = pattern;
      this.text = text;
    }
  }

  static class FastScanner {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastScanner() {
      reader = new BufferedReader(new InputStreamReader(System.in));
      tokenizer = null;
    }

    public String next() throws IOException {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        tokenizer = new StringTokenizer(reader.readLine());
      }
      return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next());
    }
  }
}

