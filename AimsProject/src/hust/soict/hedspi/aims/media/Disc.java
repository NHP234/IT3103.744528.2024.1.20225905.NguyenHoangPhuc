package hust.soict.hedspi.aims.media;
//Nguyen Hoang Phuc 20225905
public class Disc extends Media {
    private int length;
    private String director;

    //Nguyen Hoang Phuc 20225905
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public String toString() {
        return super.toString() + " - Length: " + length + " - Director: " + director;
    }
}
