package coursera.sandiego.algorithmictoolbox.week4;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }
    System.out.println(Arrays.toString(mergeSort(a,0, a.length - 1)));
  }

  public static int[] mergeSort(int[] a, int left, int right) {
    if (left >= right) {
      return new int[] { a[left] };
    }
    int mid = (right - left) / 2 + left;
    int[] b = mergeSort(a, left, mid);
    int[] c = mergeSort(a, mid + 1, right);
    return merge(b, c);
  }

  public static int[] merge(int[] b, int[] c) {
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
      } else  {
        result[i] = c[cCount];
        ++cCount;
      }
    }
    return result;
  }
}
