package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + this.title);
        System.out.println("Track length: " + this.length);
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
