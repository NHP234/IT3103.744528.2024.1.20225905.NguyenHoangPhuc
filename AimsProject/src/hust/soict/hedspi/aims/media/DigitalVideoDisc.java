package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    private static int nbDigitalVideoDiscs = 0;
    private String director;
    private int length;

    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }

    //Ham in DVD
    @Override
    public String toString() {
        return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.director + " - " + this.length + ": " + this.getCost();
    }
    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }
}