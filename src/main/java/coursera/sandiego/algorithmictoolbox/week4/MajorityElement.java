package coursera.sandiego.algorithmictoolbox.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MajorityElement {
  private static int getMajorityElement(int[] a, int left, int right) {
    if (left == right) {
      return -1;
    }
    if (left + 1 == right) {
      return a[left];
    }
    int mid = (left + right) / 2;
    int leftMaj = getMajorityElement(a, left, mid);
    int rightMaj = getMajorityElement(a, mid + 1, right);
    if (leftMaj == rightMaj) {
      return leftMaj;
    }
    int leftFreq = getFrequency(a, leftMaj);
    if (leftFreq > mid / 2 + 1) {
      return leftMaj;
    }
    int rightFreq = getFrequency(a, rightMaj);
    if (rightFreq > mid / 2 + 1) {
      return rightMaj;
    }
    return -1;
  }

  private static int getFrequency(int[] a, int element) {
    int freq = 0;
    for (int i = 0; i < a.length; ++i) {
      if (a[i] == element) {
        ++freq;
      }
    }
    return freq;
  }

  public static void main(String[] args) {
    FastScanner scanner = new FastScanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    System.out.println(getMajorityElement(a, 0, a.length));
  }

  static class FastScanner {
    BufferedReader br;
    StringTokenizer st;

    FastScanner(InputStream stream) {
      try {
        br = new BufferedReader(new InputStreamReader(stream));
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
