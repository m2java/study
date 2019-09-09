package coursera.dukeuniversity.designprinciples.week1;

import coursera.dukeuniversity.designprinciples.week1.*;
import org.junit.Test;

import java.util.ArrayList;

public class TestEarthQuakeClient {

    @Test
    public void testFilterByMagnitude() {
        EarthQuakeClient earthQuakeClient = new EarthQuakeClient();
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week1\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        earthQuakeClient.dumpCSV(earthQuakeClient.filterByMagnitude(list, 5.0));
    }

    @Test
    public void testFindClosestQuakes() {
        ClosestQuakes closestQuakes = new ClosestQuakes();
        closestQuakes.findClosestQuakes();
    }

    @Test
    public void testFindLargestQuakes() {
        LargestQuakes largestQuakes = new LargestQuakes();
        largestQuakes.findLargestQuakes();
    }

    @Test
    public void testClient2() {
        EarthQuakeClient2 client2 = new EarthQuakeClient2();
        client2.testMatchAllFilter();
    }
}
