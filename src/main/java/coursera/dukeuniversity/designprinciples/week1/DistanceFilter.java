package coursera.dukeuniversity.designprinciples.week1;

public class DistanceFilter implements Filter {
    private double dist;
    private Location location;

    public DistanceFilter(double dist, Location location) {
        this.dist = dist;
        this.location = location;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return qe.getLocation().distanceTo(location) < dist;
    }
}
