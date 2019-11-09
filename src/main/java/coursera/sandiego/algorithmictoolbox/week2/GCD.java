package coursera.sandiego.algorithmictoolbox.week2;

import java.util.Scanner;

public class GCD {
  public static int gcd(int a, int b) {
    if (a == 0 || b == 0) {
      return a != 0 ? a : b;
    }
    if (a >= b) {
      int d = a % b;
      return gcd(b, d);
    } else {
      int d = b % a;
      return gcd(a, d);
    }
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
