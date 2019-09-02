package coursera.dukeuniversity.designprinciples.week1;

import java.util.ArrayList;

public class MatchAllFilter implements Filter {
    private ArrayList<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        for (Filter filter : filters) {
            if (!filter.satisfies(qe)) {
                return false;
            }
        }
        return true;
    }
}
