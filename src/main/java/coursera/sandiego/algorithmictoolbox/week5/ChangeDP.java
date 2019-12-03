package coursera.sandiego.algorithmictoolbox.week5;

import java.util.Scanner;

public class ChangeDP {
  private static int[] coins = {1, 3, 4};

  private static int getChange(int money) {
    int[] minNumCoins = new int[money + 1];
    minNumCoins[0] = 0;
    for (int m = 1; m < money + 1; ++m) {
      minNumCoins[m] = Integer.MAX_VALUE;
      for (int i = 0; i < 3; ++i) {
        if (m >= coins[i]) {
          int numCoins = minNumCoins[m - coins[i]] + 1;
          if (numCoins < minNumCoins[m]){
            minNumCoins[m] = numCoins;
          }
        }
      }
    }
    return minNumCoins[money];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    System.out.println(getChange(m));
  }
}
