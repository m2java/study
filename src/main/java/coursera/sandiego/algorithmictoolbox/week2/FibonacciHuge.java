package coursera.sandiego.algorithmictoolbox.week2;

import java.util.Scanner;

public class FibonacciHuge {
  private static long getFibonacciHuge(long n, long m) {
    if (n <= 1)
      return n;
    long period = 0;
    long previous = 0;
    long current = 1;

    for (long i = 0; i < n - 1; ++i) {
      long tmp_previous = previous % m;
      previous = current % m;
      current = (tmp_previous + current) % m;
      if (current == 1 && previous == 0) {
        period = i + 1;
        break;
      }
    }
    long limit;
    if (period != 0) {
      limit = n % period;
      if (limit == 0) {
        limit = period;
      }
    } else {
      limit = n;
    }
    previous = 0;
    current = 1;
    for (long i = 2; i <= limit; ++i) {
      long tmp_previous = previous % m;
      previous = current % m;
      current = (tmp_previous + current) % m;
    }

    return current;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    long m = scanner.nextLong();
    System.out.println(getFibonacciHuge(n, m));
  }
}
