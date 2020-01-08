package coursera.sandiego.algorithmsongraphs.week2;

import java.util.*;

public class Toposort {
  private static Deque<Integer> toposort(ArrayList<Integer>[] adj) {
    boolean used[] = new boolean[adj.length];
    Deque<Integer> order = new LinkedList<>();
    dfs(adj,used,order);
    return order;
  }

  private static void dfs(ArrayList<Integer>[] adj, boolean[] used, Deque<Integer> order) {
    int n = adj.length;
    for (int i = 0; i < n; i++) {
      if (!used[i]) {
        used[i] = true;
        explore(adj,used,order, i);
      }
    }
  }

  private static  void explore(ArrayList<Integer>[] adj, boolean[] used, Deque<Integer> order, int v) {
    ArrayList<Integer> list = adj[v];
    for (int i: list) {
      if (!used[i]) {
        used[i] = true;
        explore(adj,used,order, i);
      }
    }
    order.push(v);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<Integer>();
    }
    for (int i = 0; i < m; i++) {
      int x, y;
      x = scanner.nextInt();
      y = scanner.nextInt();
      adj[x - 1].add(y - 1);
    }
    Deque<Integer> order = toposort(adj);
    while(!order.isEmpty()){
      System.out.print((order.poll() + 1) + " ");
    }
  }
}
