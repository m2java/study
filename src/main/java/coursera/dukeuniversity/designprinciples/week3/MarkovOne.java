package coursera.dukeuniversity.designprinciples.week3;

import java.util.ArrayList;
import java.util.Random;

public class MarkovOne {
    private String myText;
    private Random myRandom;

    public MarkovOne() {
        myRandom = new Random();
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - 1);
        String key = myText.substring(index, index + 1);
        sb.append(key);
        for (int k = 0; k < numChars - 1; k++) {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }
        return sb.toString();
    }

    public ArrayList<String> getFollows(String key) {
        ArrayList<String> result = new ArrayList<>();
        int k = 0;
        boolean flag;
        do {
            k = myText.indexOf(key, k);
            if (k > -1 && k < myText.length() - key.length()) {
                k = k + key.length();
                result.add(String.valueOf(myText.charAt(k)));
                flag = true;
            } else {
                flag = false;
            }
        }
        while (flag);
        return result;
    }
}
