package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

//Nguyen Hoang Phuc 20225905
public class Track implements Playable {
    private String title;
    private int length;
    //Nguyen Hoang Phuc 20225905
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    //Nguyen Hoang Phuc 20225905
    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing Track: " + this.title);
            System.out.println("Track length: " + this.length);
        } else {
            throw new PlayerException("ERROR: DVD length is non - positive");
        }

    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    //Nguyen Hoang Phuc 20225905
    public boolean equals(Object obj) {
        Track track = (Track) obj;
        if(track.getTitle().equals(this.title) && track.getLength() == this.length) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Title: " + this.title + ", Length: " + this.length;
    }
}
