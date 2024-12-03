package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Media {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, float cost, String artist, List<Track> tracks) {
        super(id, title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
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

}
