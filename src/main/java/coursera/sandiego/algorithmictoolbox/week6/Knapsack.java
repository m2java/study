package coursera.sandiego.algorithmictoolbox.week6;

import java.util.Scanner;

public class Knapsack {
  static int optimalWeight(int W, int[] bars) {
    int[][] value = new int[bars.length + 1][W + 1];
    for (int i = 1; i <= bars.length; ++i) {
      for (int w = 1; w <= W; ++w) {
        value[i][w] = value[i - 1][w];
        if (bars[i - 1] <= w) {
          int val = value[i - 1][w - bars[i - 1]] + bars[i - 1];
          if (value[i][w] < val) {
            value[i][w] = val;
          }
        }
        System.out.print(value[i][w] + " ");
      }
      System.out.println();
    }
    return value[bars.length][W];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int W, n;
    W = scanner.nextInt();
    n = scanner.nextInt();
    int[] w = new int[n];
    for (int i = 0; i < n; i++) {
      w[i] = scanner.nextInt();
    }
    System.out.println(optimalWeight(W, w));
  }
}
