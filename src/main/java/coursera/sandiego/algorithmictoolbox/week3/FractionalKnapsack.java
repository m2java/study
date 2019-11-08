package coursera.sandiego.algorithmictoolbox.week3;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
  private static Integer[] sortedArr;

  private static double getOptimalValue(int capacity, int[] values, int[] weights) {
    Arrays.sort(sortedArr, (o1, o2) -> Double.compare(values[o2] / weights[o2], values[o1] / weights[o1]));
    int profitIndex = 0;
    double value = 0;
    while (capacity > 0) {
      int mostProfitable = sortedArr[profitIndex];
      if (capacity - weights[mostProfitable] >= 0) {
        capacity = capacity - weights[mostProfitable];
        value += values[mostProfitable];
      } else {
        value += capacity * (double)values[mostProfitable] / weights[mostProfitable];
        capacity = 0;
      }
      ++profitIndex;
    }
    return value;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    sortedArr = new Integer[n];
    int capacity = scanner.nextInt();
    int[] values = new int[n];
    int[] weights = new int[n];
    for (int i = 0; i < n; i++) {
      values[i] = scanner.nextInt();
      weights[i] = scanner.nextInt();
      sortedArr[i] = i;
    }
    System.out.println(getOptimalValue(capacity, values, weights));
  }
}
