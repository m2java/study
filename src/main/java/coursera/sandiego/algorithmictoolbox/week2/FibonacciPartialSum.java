package coursera.sandiego.algorithmictoolbox.week2;

import java.util.Scanner;

public class FibonacciPartialSum {
  private static long getFibonacciPartialSum(long from, long to) {
    long sum = 0;

    long current = 0;
    long next  = 1;

    for (long i = 0; i <= to; ++i) {
      if (i >= from) {
        sum += current;
      }

      long new_current = next % 10;
      next = (next + current) % 10;
      current = new_current;
    }

    return sum % 10;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long from = scanner.nextLong();
    long to = scanner.nextLong();
    System.out.println(getFibonacciPartialSum(from, to));
  }
}
