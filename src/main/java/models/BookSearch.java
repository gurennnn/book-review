package models;

// this class represents the books that are found within the searching results

public class BookSearch {

    // fields
    private String title, author;
    private int date;

    // constructor
    public BookSearch(String title, String author, int date) {
        this.title = title;
        this.author = author;
        this.date = date;
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

}
