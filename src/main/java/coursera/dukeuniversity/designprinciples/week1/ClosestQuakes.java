package coursera.dukeuniversity.designprinciples.week1;
import java.util.*;

public class ClosestQuakes {

    public ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany) {
        ArrayList<QuakeEntry> copy = new ArrayList<>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            double distance = copy.get(0).getLocation().distanceTo(current);
            int min = 0;
            for (int k = 0; k < copy.size(); k++) {
                if (distance > copy.get(k).getLocation().distanceTo(current)) {
                    distance = copy.get(k).getLocation().distanceTo(current);
                    min = k;
                }
            }
            ret.add(copy.get(min));
            copy.remove(min);
        }
        return ret;
    }

    public void findClosestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week1\\nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size());

        Location jakarta = new Location(-6.211, 106.845);

        ArrayList<QuakeEntry> close = getClosest(list, jakarta, 3);
        for (int k = 0; k < close.size(); k++) {
            QuakeEntry entry = close.get(k);
            double distanceInMeters = jakarta.distanceTo(entry.getLocation());
            System.out.printf("%4.2f\t %s\n", distanceInMeters / 1000, entry);
        }
        System.out.println("number found: " + close.size());
    }

}
