package models;

public class Book {

    // available status
    public enum Status {
        TO_READ,
        READING,
        READ
    }

    // book's general info
    private String title, author;
    private int id, year, coverID;

    // book's user specific info
    private boolean isFavourite;
    private Status status;
    private int rating;
    private String review;

    // constructor
    public Book(int id, String title, String author, int year, int coverID) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.coverID = coverID;
        this.isFavourite = false;
        this.status = Status.TO_READ;
        this.rating = 0;
        this.review = "";
    }

    // getters and setters
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

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public boolean getIsFavourite() {
        return isFavourite;
    }
    public void setIsFavourite(boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }

    public int getCoverID() {
        return coverID;
    }
    public void setCoverID(int coverID) {
        this.coverID = coverID;
    }

    // toString method
    @Override
    public String toString() {
        return "id: " + id +
                ".\ntitle: '" + title + '\'' +
                ".\nauthor: '" + author + '\'' +
                ".\nyear: " + year +
                ".\ncover_id: " + coverID +
                ".\nstatus: " + status +
                ".\nrating: " + rating +
                ".\nreview: '" + review + '\'' +
                ".";
    }

}
