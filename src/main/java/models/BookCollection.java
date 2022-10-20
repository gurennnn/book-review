package models;

import java.util.ArrayList;

public class BookCollection {

    // user's book collection
    private ArrayList<Book> myCollection;

    // empty constructor
    public BookCollection() {
        this.myCollection = new ArrayList<>();
    }

    // constructor
    public BookCollection(ArrayList<Book> collection) {
        this.myCollection = collection;
    }

    // getters and setters
    public ArrayList<Book> getMyCollection() {
        return myCollection;
    }
    public void setMyCollection(ArrayList<Book> myCollection) {
        this.myCollection = myCollection;
    }

    // adding a book to the book collection
    public void addBook(Book book) {
        this.myCollection.add(book);
    }

    // removing a book from the book collection
    public void removeBook(Book book) {
        this.myCollection.remove(book);
    }

    // more methods (sorting and filtering) ...
}
