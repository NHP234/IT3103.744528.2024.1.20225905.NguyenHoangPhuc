package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
    }

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
        String s = super.toString();
        s += ", Artist: " + artist;
        s += "\n";
        for(Track track : tracks) {
            s += track.toString() + "\n";
        }
        return s;
    }
}
