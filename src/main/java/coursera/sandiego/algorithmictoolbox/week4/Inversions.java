package coursera.sandiego.algorithmictoolbox.week4;

import java.util.Arrays;
import java.util.Scanner;

public class Inversions {

  public static int[] getNumberOfInversions(int[] a, long[] numberOfInversions,
      int left, int right) {
    if (left >= right) {
      return new int[] { a[left] };
    }
    int mid = (right - left) / 2 + left;
    int[] b = getNumberOfInversions(a, numberOfInversions, left, mid);
    int[] c = getNumberOfInversions(a, numberOfInversions, mid + 1, right);
    return merge(b, c, numberOfInversions);
  }

  public static int[] merge(int[] b, int[] c, long[] numberOfInversions) {
    int bLen = b.length;
    int cLen = c.length;
    int[] result = new int[bLen + cLen];
    int bCount = 0;
    int cCount = 0;
    for (int i = 0; i < result.length; ++i) {
      if (bCount >= bLen) {
        result[i] = c[cCount];
        ++cCount;
        continue;
      }
      if (cCount >= cLen) {
        result[i] = b[bCount];
        ++bCount;
        continue;
      }
      if (b[bCount] <= c[cCount]) {
        result[i] = b[bCount];
        ++bCount;
      } else {
        result[i] = c[cCount];
        ++cCount;
        numberOfInversions[0] += bLen - bCount;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    long[] numberOfInversions = new long[] { 0 };
    System.out.println(Arrays.toString(
        getNumberOfInversions(a, numberOfInversions, 0, a.length - 1)));
    System.out.println(Arrays.toString(numberOfInversions));
  }
}
