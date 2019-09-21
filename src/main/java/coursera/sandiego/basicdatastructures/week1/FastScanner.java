package coursera.sandiego.basicdatastructures.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastScanner {
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
