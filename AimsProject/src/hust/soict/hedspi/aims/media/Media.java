package hust.soict.hedspi.aims.media;

import java.util.Comparator;

//Nguyen Hoang Phuc 20225905
public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private float cost;
    //Nguyen Hoang Phuc 20225905
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    //Nguyen Hoang Phuc 20225905
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    //Nguyen Hoang Phuc 20225905
    @Override
    public boolean equals(Object obj) {
        Media media = (Media) obj;
        return media.getTitle().equals(this.getTitle());
    }
    //Nguyen Hoang Phuc 20225905
    public String toString(){
        return "ID: " + this.getId() + " - Title: " + this.getTitle() + " - Category: " +
                this.getCategory() + " - Cost: " + this.getCost() + "$";
    }
    //Nguyen Hoang Phuc 20225905
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    //Sort by title then cost
    public int compareTo(Media other) {
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison == 0) {
            return Float.compare(this.cost, other.cost);
        }
        return titleComparison;
    }

}
