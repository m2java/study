package coursera.sandiego.algorithmsongraphs.week3;

import java.util.*;

public class BFS {
  private static int distance(ArrayList<Integer>[] adj, int s, int t) {
    int[] distance = new int[adj.length];
    for (int i = 0; i < adj.length; i++) {
      distance[i] = -1;
    }
    distance[s] = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(s);
    while (queue.size() > 0) {
      int u = queue.poll();
      ArrayList<Integer> list = adj[u];
      for (int v : list) {
        if (distance[v] == -1) {
          distance[v] = distance[u] + 1;
          if (v == t) {
            break;
          }
          queue.offer(v);
        }
      }
    }
    return distance[t];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < m; i++) {
      int x, y;
      x = scanner.nextInt();
      y = scanner.nextInt();
      adj[x - 1].add(y - 1);
      adj[y - 1].add(x - 1);
    }
    int x = scanner.nextInt() - 1;
    int y = scanner.nextInt() - 1;
    System.out.println(distance(adj, x, y));
  }
}
