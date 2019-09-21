package coursera.sandiego.basicdatastructures.week1;

import java.io.IOException;

public class TreeHeightTest {

  public static void main(String[] args) {
    new Thread(null, new Runnable() {
      public void run() {
        try {
          new TreeHeight().run();
        } catch (IOException e) {
        }
      }
    }, "1", 1 << 26).start();
  }
}
