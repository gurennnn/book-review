package models;

public class Book {

    // available status
    public enum Status {
        TO_READ,
        READING,
        READ;
    }

    // book's general info
    private String title, author;
    private int date;

    // book's user specific info
    private boolean isFavourite;
    private Status status;
    private int rating;
    private String revue;

    // constructor
    public Book(String title, String author, int date) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.isFavourite = false;
        this.status = Status.TO_READ;
        this.rating = 0;
        this.revue = "";
    }

    // getters and setters
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

    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
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

    public String getRevue() {
        return revue;
    }
    public void setRevue(String revue) {
        this.revue = revue;
    }

    // toString method

    @Override
    public String toString() {
        return "title: '" + title + '\'' +
                ".\nauthor: '" + author + '\'' +
                ".\ndate: " + date +
                ".\nstatus: " + status +
                ".\nrating: " + rating +
                ".\nrevue: '" + revue + '\'' +
                ".";
    }
}