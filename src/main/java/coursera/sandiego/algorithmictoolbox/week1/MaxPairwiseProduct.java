package coursera.sandiego.algorithmictoolbox.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {
  static long getMaxPairwiseProduct(int[] numbers) {
    int first = -1;
    int second = -1;
    int n = numbers.length;
    for (int i = 0; i < n; ++i) {
      if (first== -1 || numbers[first] < numbers[i]) {
        first = i;
      }
    }

    for (int i = 0; i < n; ++i) {
      if (second == -1 || (numbers[second] < numbers[i] && i!= first)) {
        second = i;
      }
    }
    return (long)numbers[first]*numbers[second];
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = scanner.nextInt();
    }
    System.out.println(getMaxPairwiseProduct(numbers));
  }

  public static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
      try {
        br = new BufferedReader(new
        InputStreamReader(stream));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    String next() {
      while (st == null || !st.hasMoreTokens()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }
  }
}
