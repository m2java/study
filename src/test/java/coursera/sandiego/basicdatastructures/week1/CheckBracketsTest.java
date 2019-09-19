package coursera.sandiego.basicdatastructures.week1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class CheckBracketsTest {

  @Test
  public void test() {
    Path resourceDirectory = Paths
        .get("src", "main", "resources", "coursera", "sandiego",
            "basicdatastructures", "week1");
    try (Stream<Path> stream = Files.walk(resourceDirectory)) {
      stream.filter(Files::isRegularFile).map(x -> {
        String text = readFile(x);
        return text;
      }).map(s -> {
        CheckBrackets checkBrackets = new CheckBrackets();
        boolean result = checkBrackets.check(s);
        return result;
      }).forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public String readFile(Path path) {
    String line;
    String text = "";
    try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
      while ((line = bufferedReader.readLine()) != null) {
        text = text + line;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(text);
    return text;
  }
}
