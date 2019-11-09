package coursera.sandiego.algorithmictoolbox.week1;

import java.util.Scanner;

public class APlusB {

  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    scanner.close();
    System.out.println(sumOfTwoDigits(a, b));
  }

  private static int sumOfTwoDigits(int a, int b) {
    return a + b;
  }
}
