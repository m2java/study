package coursera.sandiego.algorithmictoolbox.week2;

import java.util.Scanner;

public class FibonacciLastDigit {
  private static int getFibonacciLastDigit(int n) {
    if (n <= 1)
      return n;

    int previous = 0;
    int current  = 1;

    for (int i = 2; i <= n; ++i) {
      int tmp_previous = previous % 10;
      previous = current % 10;
      current = tmp_previous + current;
    }

    return current % 10;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int c = getFibonacciLastDigit(n);
    System.out.println(c);
  }
}
