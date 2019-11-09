package coursera.sandiego.algorithmictoolbox.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LargestNumber {
  private static String largestNumber(String[] a) {
    String result = "";
    List<String> digits = new ArrayList(Arrays.asList(a));
    while (!digits.isEmpty()) {
      int max = Integer.MIN_VALUE;
      for (String digitString : digits) {
        if (max < 0 || compare(digitString, max)) {
          max = Integer.parseInt(digitString);
        }
      }
      result += max;
      digits.remove(String.valueOf(max));
    }
    return result;
  }

  public static boolean compare(String digitString, int max) {
    String maxString = Integer.toString(max);
    while (digitString.length() > 0) {
      char digitCahr = digitString.charAt(0);
      char maxChar = maxString.charAt(0);
      if (digitCahr < maxChar) {
        return false;
      }
      digitString = digitString.substring(1);
      if (maxString.length() > 1) {
        maxString = maxString.substring(1);
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String[] a = new String[n];
    for (int i = 0; i < n; i++) {
      a[i] = scanner.next();
    }
    System.out.println(largestNumber(a));
  }
}
