package coursera.dukeuniversity.designprinciples.week2;

import coursera.dukeuniversity.designprinciples.week1.Location;
import coursera.dukeuniversity.designprinciples.week1.QuakeEntry;

import java.util.Comparator;

public class DistanceComparator implements Comparator<QuakeEntry> {
    private Location whereFrom;

    public DistanceComparator(Location where) {
        this.whereFrom = where;
    }

    @Override
    public int compare(QuakeEntry o1, QuakeEntry o2) {
        double dist1 = o1.getLocation().distanceTo(whereFrom);
        double dist2 = o2.getLocation().distanceTo(whereFrom);
        return Double.compare(dist1, dist2);
    }
}
