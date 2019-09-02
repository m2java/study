package coursera.dukeuniversity.designprinciples.week2;

import coursera.dukeuniversity.designprinciples.week1.QuakeEntry;

import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    @Override
    public int compare(QuakeEntry o1, QuakeEntry o2) {
        String word1;
        String word2;
        int index1 = o1.getInfo().lastIndexOf(" ");
        if (index1 != -1) {
            word1 = o1.getInfo().substring(index1);
        } else {
            word1 = o1.getInfo();
        }
        int index2 = o2.getInfo().lastIndexOf(" ");
        if (index2 != -1) {
            word2 = o2.getInfo().substring(index2);
        } else {
            word2 = o2.getInfo();
        }
        if (word1.compareTo(word2) == 0) {
            return Double.compare(o1.getMagnitude(), o2.getMagnitude());
        }
        return word1.compareTo(word2);
    }
}
