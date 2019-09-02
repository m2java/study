package coursera.coursera.dukeuniversity.designprinciples.week2;

import coursera.dukeuniversity.designprinciples.week1.EarthQuakeParser;
import coursera.dukeuniversity.designprinciples.week1.QuakeEntry;
import coursera.dukeuniversity.designprinciples.week2.QuakeSortInPlace;
import coursera.dukeuniversity.designprinciples.week2.TitleAndDepthComparator;
import coursera.dukeuniversity.designprinciples.week2.TitleLastAndMagnitudeComparator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestWeek2 {
    @Test
    public void test() {
        QuakeSortInPlace s = new QuakeSortInPlace();
        s.testSort();
    }

    @Test
    public void testComparator() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week1\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);

        System.out.println("read data for " + list.size() + " quakes");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        Collections.sort(list);

        System.out.println("EarthQuakes in sorted order:");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        int quakeNumber = 10;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

    @Test
    public void sortByTitleAndDepthTest() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week1\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);

        System.out.println("read data for " + list.size() + " quakes");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        Collections.sort(list, new TitleAndDepthComparator());

        System.out.println("EarthQuakes in sorted order:");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        int quakeNumber = 10;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

    @Test
    public void testSpike() {
        String o1 = "kekkukyou";
        System.out.println(o1.substring(o1.lastIndexOf(" ")));
    }

    @Test
    public void sortByLastWordInTitleThenByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week1\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);

        System.out.println("read data for " + list.size() + " quakes");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        Collections.sort(list, new TitleLastAndMagnitudeComparator());

        System.out.println("EarthQuakes in sorted order:");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        int quakeNumber = 10;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

    @Test
    public void testComparatorFinal() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week2\\earthQuakeDataDec6sample2.atom";
        ArrayList<QuakeEntry> list = parser.read(source);

        System.out.println("read data for " + list.size() + " quakes");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        Collections.sort(list);

        System.out.println("EarthQuakes in sorted order:");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        int quakeNumber = 50;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

    @Test
    public void sortByTitleAndDepthTestFinal() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week2\\earthQuakeDataDec6sample1.atom";
        ArrayList<QuakeEntry> list = parser.read(source);

        System.out.println("read data for " + list.size() + " quakes");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        Collections.sort(list, new TitleAndDepthComparator());

        System.out.println("EarthQuakes in sorted order:");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        int quakeNumber = 50;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

    @Test
    public void sortByLastWordInTitleThenByMagnitudeFinal() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week2\\earthQuakeDataDec6sample1.atom";
        ArrayList<QuakeEntry> list = parser.read(source);

        System.out.println("read data for " + list.size() + " quakes");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        Collections.sort(list, new TitleLastAndMagnitudeComparator());

        System.out.println("EarthQuakes in sorted order:");
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }

        int quakeNumber = 50;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(list.get(quakeNumber));
    }

}
