package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }

    public String toString() {
        return super.toString();
    }
}