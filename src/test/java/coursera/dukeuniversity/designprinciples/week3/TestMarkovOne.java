package coursera.dukeuniversity.designprinciples.week3;

import coursera.dukeuniversity.designprinciples.week3.MarkovOne;
import coursera.dukeuniversity.designprinciples.week3.MarkovZero;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestMarkovOne {

    @Test
    public void testGetFollows() {
        String s = "this is a test yes this is a test.";
        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(s);
        System.out.println(markovOne.getFollows("es"));
    }

    @Test
    public void testGetFollowsWithFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week3\\confucius.txt"));
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            text.append(line);
            text.replace(text.length(), text.length(), " ");
        }
        text.delete(text.length() - 1, text.length());
        br.close();

        MarkovOne markovOne = new MarkovOne();
        markovOne.setTraining(text.toString());

        System.out.println(markovOne.getFollows("t").size());
    }

    @Test
    public void testGetRandomTextWithFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week3\\confucius.txt"));
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            text.append(line);
            text.replace(text.length(), text.length(), " ");
        }
        text.delete(text.length() - 1, text.length());
        br.close();

        MarkovOne markovOne = new MarkovOne();
        markovOne.setRandom(42);
        markovOne.setTraining(text.toString());
        System.out.println(markovOne.getRandomText(200));
    }
}

