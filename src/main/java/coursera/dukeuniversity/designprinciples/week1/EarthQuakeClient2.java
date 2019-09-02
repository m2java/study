package coursera.dukeuniversity.designprinciples.week1;

import java.util.ArrayList;

public class EarthQuakeClient2 {
    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) {
        ArrayList<QuakeEntry> result = new ArrayList<>();
        for (QuakeEntry qe : quakeData) {
            if (f.satisfies(qe)) {
                result.add(qe);
            }
        }
        return result;
    }

    public void quakesWithFilter() {
        EarthQuakeParser quakeParser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = quakeParser.read("C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week1\\nov20quakedata.atom");
        /*MagnitudeFilter magnitudeFilter = new MagnitudeFilter(4.0, 5.0);
        DepthFilter depthFilter = new DepthFilter(-35000.0, -12000.0);
        ArrayList<QuakeEntry> result = filter(list, magnitudeFilter);
        ArrayList<QuakeEntry> result2 = filter(result, depthFilter);*/
        DistanceFilter distanceFilter = new DistanceFilter(10000000, new Location(35.42, 139.43));
        PhraseFilter phraseFilter = new PhraseFilter("end", "Japan");
        ArrayList<QuakeEntry> result = filter(list, distanceFilter);
        ArrayList<QuakeEntry> result2 = filter(result, phraseFilter);
        System.out.println(result2);
        System.out.println(result2.size());
    }

    public void testMatchAllFilter() {
        EarthQuakeParser quakeParser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = quakeParser.read("C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week1\\nov20quakedata.atom");
        MatchAllFilter matchAllFilter = new MatchAllFilter();
        matchAllFilter.addFilter(new MagnitudeFilter(0.0, 2.0));
        matchAllFilter.addFilter(new DepthFilter(-100000.0, -10000.0));
        matchAllFilter.addFilter(new PhraseFilter("any", "a"));

        ArrayList<QuakeEntry> result = filter(list, matchAllFilter);
        System.out.println(result);
        System.out.println(result.size());
    }

    public void testMatchAllFilter2 () {
        EarthQuakeParser quakeParser = new EarthQuakeParser();
        ArrayList<QuakeEntry> list = quakeParser.read("C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week1\\nov20quakedata.atom");
        MatchAllFilter matchAllFilter = new MatchAllFilter();
        matchAllFilter.addFilter(new MagnitudeFilter(0.0, 3.0));
        matchAllFilter.addFilter(new DistanceFilter(10000000, new Location(36.1314, -95.9372)));
        matchAllFilter.addFilter(new PhraseFilter("any", "Ca"));

        ArrayList<QuakeEntry> result = filter(list, matchAllFilter);
        System.out.println(result);
        System.out.println(result.size());
    }
}
