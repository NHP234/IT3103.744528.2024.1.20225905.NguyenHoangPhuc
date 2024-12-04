package hust.soict.hedspi.aims.media;
//Nguyen Hoang Phuc 20225905
import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        int titleComparison = m1.getTitle().compareTo(m2.getTitle());
        if(titleComparison != 0) {
            return titleComparison;
        }
        return Float.compare(m2.getCost(), m1.getCost());
    }
}
