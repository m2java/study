package coursera.sandiego.algorithmsongraphs.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFS {
  private static int n;
  private static int m;
  private static boolean[] visited;
  private static int[] pre;
  private static int[] post;
  private static ArrayList<Integer>[] adj;
  private static int clock = 1;

  public static void explore(int v) {
    System.out.println(v+1);
    ArrayList<Integer> list = adj[v];
    for (int subvertix : list) {
      if (!visited[subvertix]) {
        visited[subvertix] = true;
        pre(subvertix);
        explore(subvertix);
        post(subvertix);
      }
    }
  }

  public static void pre(int v) {
    pre[v] = clock;
    clock++;
  }

  public static void post(int v) {
    post[v] = clock;
    clock++;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    n = scanner.nextInt();
    m = scanner.nextInt();
    visited = new boolean[n];
    pre = new int[n];
    post = new int[n];
    adj = (ArrayList<Integer>[]) new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
      int x, y;
      x = scanner.nextInt();
      y = scanner.nextInt();
      adj[x - 1].add(y - 1);
      adj[y - 1].add(x - 1);
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        visited[i] = true;
        pre(i);
        explore(i);
        post(i);
      }
    }
  }
}

