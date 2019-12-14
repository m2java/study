package coursera.sandiego.algorithmictoolbox.week5;

import java.util.Scanner;

public class LCS2 {
  private static int lcs2(int[] a, int[] b) {
    int[][] arr = new int[b.length + 1][a.length + 1];
    for (int i = 0; i <= b.length; ++i) {
      for (int j = 0; j <= a.length; ++j) {
        if (i == 0 || j == 0) {
          arr[i][j] = 0;
        } else if (b[i-1] == a[j-1]) {
          arr[i][j] = arr[i - 1][j - 1] + 1;
        } else {
          arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
        }
      }
    }
    return arr[b.length][a.length];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.nextInt();
    }

    int m = scanner.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = scanner.nextInt();
    }

    System.out.println(lcs2(a, b));
  }
}
