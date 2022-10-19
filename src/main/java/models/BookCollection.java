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

    // show your book collection
    public void showCollection() {
        if (this.myCollection.isEmpty()) {
            System.out.println("Empty Collection !!!");
        } else {
            System.out.println("---------- Displaying your Book collection ----------");
            int counter = 1;
            for (Book book : this.myCollection) {
                System.out.println("### Book " + counter + " ###");
            }
        }
    }

    // adding a book to the book collection
    public void addBook(Book book) {
        this.myCollection.add(book);
    }

    // removing a book from the book collection
    public void removeBook(Book book) {
        this.myCollection.remove(book);
    }

}
