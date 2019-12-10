package coursera.sandiego.algorithmictoolbox.week5;

import java.util.Scanner;

public class EditDistance {
  public static int EditDistance(String s, String t) {
    int[][] matrix = new int[s.length()+1][t.length()+1];
    for (int i = 1; i <= s.length(); ++i) {
      matrix[i][0] = i;
    }
    for (int i = 1; i <= t.length(); ++i) {
      matrix[0][i] = i;
    }
    for (int i = 1; i <= s.length(); ++i) {
      for (int j = 1; j <= t.length(); ++j) {
        int insertion = matrix[i][j - 1] + 1;
        int deletion = matrix[i - 1][j] + 1;
        int match = matrix[i - 1][j - 1];
        int mismatch = matrix[i - 1][j - 1] + 1;
        if (s.charAt(i-1) == t.charAt(j-1)) {
          matrix[i][j] = Math.min(Math.min(insertion, deletion), match);
        } else {
          matrix[i][j] = Math.min(Math.min(insertion, deletion), mismatch);
        }
      }
    }
    return matrix[s.length()][t.length()];
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }
}
