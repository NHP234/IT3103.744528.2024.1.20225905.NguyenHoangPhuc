package hust.soict.hedspi.aims.media;
//Nguyen Hoang Phuc 20225905
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        int costComparison = Float.compare(m2.getCost(), m1.getCost());
        if(costComparison != 0) {
            return costComparison;
        }
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
