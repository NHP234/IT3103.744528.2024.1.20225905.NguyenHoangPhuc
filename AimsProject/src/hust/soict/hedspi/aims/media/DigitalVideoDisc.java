package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable, Comparable<Media>{
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }
    //Nguyen Hoang Phuc 20225905
    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }
        else throw new PlayerException("ERROR: DVD length is non - positive");

    }
    public String toString() {
        return super.toString();
    }
    public int compareTo(Media other) {
        if (other instanceof DigitalVideoDisc) {
            DigitalVideoDisc otherDVD = (DigitalVideoDisc) other;
            int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
            if (titleComparison == 0) {
                int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
                if (lengthComparison == 0) {
                    return Float.compare(this.getCost(), otherDVD.getCost());
                }
                return lengthComparison;
            }
            return titleComparison;
        } else {
            return super.compareTo(other);
        }
    }
}