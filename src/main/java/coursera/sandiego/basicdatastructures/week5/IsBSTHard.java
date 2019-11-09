package coursera.sandiego.basicdatastructures.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IsBSTHard {

  int nodes;
  Node[] tree;

  void read() throws IOException {
    FastScanner in = new FastScanner();
    nodes = in.nextInt();
    tree = new Node[nodes];
    for (int i = 0; i < nodes; i++) {
      tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
    }

  }

  public boolean solve() {
    return isBST(tree[0], new Node(Integer.MIN_VALUE, -1, -1), false);
  }

  public boolean isBST(Node node, Node prev, boolean isRight) {

    if (node.left != -1) {
      if (!isBST(tree[node.left], prev, false)) {
        return false;
      }
    }
    if (isRight) {
      if (prev.key > node.key) {
        return false;
      }
    } else {
      if (prev.key >= node.key) {
        return false;
      }
    }

    prev.key = node.key;

    if (node.right != -1) {
      if (!isBST(tree[node.right], prev, true)) {
        return false;
      }
    }
    return true;
  }

  static public void main(String[] args) throws IOException {
    new Thread(null, new Runnable() {
      public void run() {
        try {
          new IsBST().run();
        } catch (IOException e) {
        }
      }
    }, "1", 1 << 26).start();
  }

  public void run() throws IOException {
    IsBST tree = new IsBST();
    tree.read();
    if (tree.solve()) {
      System.out.println("CORRECT");
    } else {
      System.out.println("INCORRECT");
    }
  }

  public static class FastScanner {
    StringTokenizer tok = new StringTokenizer("");
    BufferedReader in;

    public FastScanner() {
      in = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
      while (!tok.hasMoreElements())
        tok = new StringTokenizer(in.readLine());
      return tok.nextToken();
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }
  }

  public static class Node {
    int key;
    int left;
    int right;

    public Node(int key, int left, int right) {
      this.left = left;
      this.right = right;
      this.key = key;
    }
  }
}

