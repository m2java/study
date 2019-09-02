package coursera.dukeuniversity.designprinciples.week1;

public class PhraseFilter implements Filter {
    private String place;
    private String phrase;

    public PhraseFilter(String place, String phrase) {
        this.place = place;
        this.phrase = phrase;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        switch(place) {
            case "start" : return qe.getInfo().startsWith(phrase);
            case "end" : return qe.getInfo().endsWith(phrase);
            case "any" : return qe.getInfo().contains(phrase);
        }
        return false;
    }
}
