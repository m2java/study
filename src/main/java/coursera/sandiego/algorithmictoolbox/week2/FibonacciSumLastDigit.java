package coursera.sandiego.algorithmictoolbox.week2;

import java.util.Scanner;

public class FibonacciSumLastDigit {
  private static long getFibonacciSum(long n) {
    if (n <= 1)
      return n;

    long previous = 0;
    long current  = 1;
    long sum      = 1;

    for (long i = 0; i < n - 1; ++i) {
      long tmp_previous = previous % 10;
      previous = current  % 10;
      current = (tmp_previous + current) % 10;
      sum += current;
    }
    return sum % 10;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    long s = getFibonacciSum(n);
    System.out.println(s);
  }
}
