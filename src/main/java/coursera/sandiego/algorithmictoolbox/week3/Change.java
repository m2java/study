package coursera.sandiego.algorithmictoolbox.week3;

import java.util.Scanner;

public class Change {
  private static int getChange(int m) {
    int coinSizeIndex = 0;
    int[] coinsSizes = {10, 5, 1};
    int[] coinsResult = new int[3];
    while (m > 0) {
      int subResult = m / coinsSizes[coinSizeIndex];
      m = m % coinsSizes[coinSizeIndex];
      coinsResult[coinSizeIndex] = subResult;
      ++coinSizeIndex;
    }
    int result = 0;
    for (int i : coinsResult) {
      result += i;
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    System.out.println(getChange(m));
  }
}
