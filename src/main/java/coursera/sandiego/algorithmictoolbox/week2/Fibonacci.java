package coursera.sandiego.algorithmictoolbox.week2;

import java.util.Scanner;

public class Fibonacci {
  private static long calcFib(int n) {
    long prev = 0l;
    long last = 1l;
    if (n <= 1) {
      return n;
    }
    for (int i = 2; i <= n; ++i) {
      last = prev + last;
      prev = last - prev;
    }
    return last;
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calcFib(n));
  }
}
