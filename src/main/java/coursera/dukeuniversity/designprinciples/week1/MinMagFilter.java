package coursera.dukeuniversity.designprinciples.week1;

public class MinMagFilter implements Filter {
    private double minMag;

    public MinMagFilter(double min) {
        this.minMag = min;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return qe.getMagnitude() >= minMag;
    }
}
