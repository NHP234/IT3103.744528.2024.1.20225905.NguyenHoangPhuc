package hust.soict.hedspi.aims.media;
//Nguyen Hoang Phuc 20225905
import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {
        if(!authors.contains(authorName)) {
            authors.add(authorName);
        }
        else System.out.println("Author is already in the list");
    }
    //Nguyen Hoang Phuc 20225905
    public void removeAuthor(String authorName) {
        if(authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author is removed");
        }
        else System.out.println("Author is not in the list");
    }

    public String toString() {
        return super.toString() + " - Authors: " + authors;
    }
}

