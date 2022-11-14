package models;

public class Book {

    // available status
    public enum Status {
        TO_READ,
        READING,
        READ;
    }

    // available genres
    public enum Genre {
        NOVEL,
        POETRY,
        THEATRICAL,
        ESSAY,
        BIOGRAPHY;
    }

    // available categories
    public enum Category {
        ACTION,
        ADVENTURE,
        BUSINESS,
        COMEDY,
        ECONOMY,
        HEALTH,
        HISTORY,
        HORROR,
        MYSTERY,
        PHILOSOPHY,
        POLITICS,
        RELIGION,
        ROMANCE,
        SCIENCE,
        SPORT;
    }

    // book's general info
    private String title, author;
    private int date;
    private Genre genre;
    private Category category;

    // book's user specific info
    private boolean isFavourite;
    private Status status;
    private int rating;
    private String revue;

    // constructor
    public Book(String title, String author, int date, Genre genre, Category category) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.category = category;
        this.date = date;
        this.status = Status.TO_READ;
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

    public Genre getGenre() {
        return this.genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
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
                ".\ngenre: " + genre +
                ".\ncategory: " + category +
                ".\nstatus: " + status +
                ".\nrating: " + rating +
                ".\nrevue: '" + revue + '\'' +
                ".";
    }
}