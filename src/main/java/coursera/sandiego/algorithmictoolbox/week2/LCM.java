package coursera.sandiego.algorithmictoolbox.week2;

import java.util.Scanner;

public class LCM {
  private static long lcm(int a, int b) {
   return (long)a*b / GCD.gcd(a,b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}
