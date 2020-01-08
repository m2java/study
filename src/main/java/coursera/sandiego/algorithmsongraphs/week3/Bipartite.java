package coursera.sandiego.algorithmsongraphs.week3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
  private static int bipartite(ArrayList<Integer>[] adj) {
    int[] status = new int[adj.length];
    for (int i = 0; i < adj.length; i++) {
      status[i] = -1;
    }
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(0);
    while (queue.size() > 0) {
      int vertex = queue.poll();
      if (status[vertex] == -1) {
        status[vertex] = 0;
      }
      ArrayList<Integer> list = adj[vertex];
      for (int u : list) {
        if (status[u] == -1) {
          status[u] = status[vertex] == 0 ? 1 : 0;
          queue.offer(u);
        } else if ((status[u] == 0 && status[vertex] == 0) || (status[u] == 1 && status[vertex] == 1)) {
          return 0;
        }
      }
    }
    return 1;
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
    System.out.println(bipartite(adj));
  }
}