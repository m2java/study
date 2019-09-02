package coursera.dukeuniversity.designprinciples.week1;

public class DepthFilter implements Filter {
    private double minDepth;
    private double maxDepth;

    public DepthFilter(double min, double max) {
        this.minDepth = min;
        this.maxDepth = max;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth;
    }
}
