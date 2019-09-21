package coursera.sandiego.basicdatastructures.week1;

import java.io.IOException;

public class TreeHeight {
  int n;
  int parent[];
  int heights[];

  void read() throws IOException {
    FastScanner in = new FastScanner();
    n = in.nextInt();
    parent = new int[n];
    heights = new int[n];

    for (int i = 0; i < n; i++) {
      parent[i] = in.nextInt();
    }
  }

  int computeHeight() {
    int maxHeight = 0;
    for (int vertex = 0; vertex < n; vertex++) {
      int height = 0;
      for (int i = vertex; i != -1; i = parent[i]) {
        height++;
      }
      maxHeight = Math.max(height, maxHeight);
    }
    return maxHeight;
  }

  int computeHeightQuick() {
    int maxHeight = 0;
    for (int vertex = 0; vertex < n; vertex++) {
      int height = 0;
      for (int i = vertex; i != -1; i = parent[i]) {
        int nodeHeight = heights[i];
        if (nodeHeight == 0) {
          height++;
          heights[vertex] = height;
        } else {
          height = height + nodeHeight;
          heights[vertex] = height;
          break;
        }
      }
      maxHeight = Math.max(height, maxHeight);
    }
    return maxHeight;
  }

  public void run() throws IOException {
    TreeHeight tree = new TreeHeight();
    tree.read();
    System.out.println(tree.computeHeightQuick());
  }
}
