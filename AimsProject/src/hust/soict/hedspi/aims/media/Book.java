package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private List<String> authors = new ArrayList<String>();

    public Book() {

    }

    void addAuthor(String authorName) {
        if(!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    void removeAuthor(String authorName) {
        authors.remove(authorName);
    }
}

