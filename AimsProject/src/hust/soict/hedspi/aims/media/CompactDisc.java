package hust.soict.hedspi.aims.media;
//Nguyen Hoang Phuc 20225905
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();
    //Nguyen Hoang Phuc 20225905
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }
    //Nguyen Hoang Phuc 20225905
    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + getArtist());
        for(Track track : tracks) {
            track.play();
        }
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if(!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added!");
        }
        else System.out.println("Track already added!");
    }
    //Nguyen Hoang Phuc 20225905
    public void removeTrack(Track track) {
        if(tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed!");
        }
        else System.out.println("Track does not exist!");
    }

    public int getLength() {
        int length = 0;
        for(Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public String toString() {
        StringBuilder s = new StringBuilder(super.toString());
        s.append(", Artist: ").append(artist);

        if (!tracks.isEmpty()) {
            s.append("\n");
            for (int i = 0; i < tracks.size(); i++) {
                s.append(tracks.get(i).toString());
                if (i < tracks.size() - 1) {
                    s.append("\n");
                }
            }
        }

        return s.toString();
    }
}
