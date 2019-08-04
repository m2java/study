package coursera.dukeuniversity.designprinciples.week1;

import java.util.ArrayList;

public class LargestQuakes {

    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "C:\\Users\\zemli\\Documents\\GitHub\\study\\src\\main\\resources\\coursera.dukeuniversity.designprinciples\\week1\\nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for " + list.size());
        ArrayList<QuakeEntry> list2  = getLargest(list, 5);
        System.out.println(list2.size());
        System.out.println("Largest value " + list2);
    }

    public int indexOfLargest(ArrayList<QuakeEntry> list) {
        int max = 0;
        double maxMag = list.get(0).getMagnitude();
        for (int i = 1; i < list.size(); i++) {
            if (maxMag < list.get(i).getMagnitude()) {
                max = i;
                maxMag = list.get(i).getMagnitude();
            }
        }
        return max;
    }

    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> copy = new ArrayList<>(quakeData);
        ArrayList<QuakeEntry> result = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            int maxId = indexOfLargest(copy);
            result.add(copy.get(maxId));
            copy.remove(maxId);
        }
        if (result.size() < howMany) {
            return quakeData;
        } else {
            return result;
        }
    }
}
