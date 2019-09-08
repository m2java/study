package coursera.dukeuniversity.designprinciples.week3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MarkovRunner {
    public void runMarkovZero() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week3\\file"));
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            text.append(line);
            text.replace(text.length(), text.length(), " ");
        }
        text.delete(text.length()-1, text.length());
        br.close();

        MarkovZero markovZero = new MarkovZero();
        markovZero.setTraining(text.toString());
        for (int i =0; i < 3; i ++ ) {
            printOut(markovZero.getRandomText(text.length()));
        }
    }

    public void runMarkovOne() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week3\\file"));
        StringBuilder text = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            text.append(line);
            text.replace(text.length(), text.length(), " ");
        }
        text.delete(text.length()-1, text.length());
        br.close();

        MarkovZero markovZero = new MarkovZero();
        markovZero.setTraining(text.toString());
        for (int i =0; i < 3; i ++ ) {
            printOut(markovZero.getRandomText(text.length()));
        }
    }

    private void printOut(String s) {
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for (int k = 0; k < words.length; k++) {
            System.out.print(words[k] + " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }

    public static void main(String[] args) throws IOException {
        new MarkovRunner().runMarkovOne();
    }
}
