package coursera.dukeuniversity.designprinciples.week1;

public class MagnitudeFilter implements Filter {
    private double minMag;
    private double maxMag;

    public MagnitudeFilter(double min, double max) {
        this.minMag = min;
        this.maxMag = max;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return qe.getMagnitude() >= minMag && qe.getMagnitude() <= maxMag;
    }
}
