package coursera.sandiego.algorithmsongraphs.week1;

import java.util.*;

public class ConnectedComponents {

  private static ArrayList<Integer>[] adj;
  private static List<Integer> visited;
  private static int numberOfComponents(ArrayList<Integer>[] adj) {
    int result = 0;
    int n = adj.length;
    visited = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      if (visited.contains(i)) {
        continue;
      } else {
        explore(i);
        ++result;
      }
    }
    return result;
  }

  private static void explore(int current) {
    visited.add(current);
    for (int i: adj[current]) {
      if (visited.contains(i)) {
        continue;
      } else {
        explore(i);
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    adj = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; ++i) {
      adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
      int x, y;
      x = scanner.nextInt();
      y = scanner.nextInt();
      adj[x - 1].add(y - 1);
      adj[y - 1].add(x - 1);
    }
    System.out.println(numberOfComponents(adj));
  }
}
