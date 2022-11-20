package services;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;


import models.Book;
import models.BookCollection;
import viewmodels.AppView;


public class DBInteraction {

    static String dbPath = "C:\\Users\\ASUS\\IdeaProjects\\book-review\\src\\main\\resources\\data\\BookReviewDB.db";

    // deleting a book by id
    public static void deleteBookById(int bookId) {
        String query1 = "DELETE FROM collection " +
                "WHERE id = " + bookId + ";";
        try(
                Connection con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
                Statement statement = con.createStatement()
                ) {
            statement.executeUpdate(query1);
        } catch (SQLException e) {
            System.out.println("error deleting");
        }
    }

    // updating a book's rating, status and review by id
    public static void updateBookById(int bookId, int isFavourite, int rating, String status, String review) {
        String query = "UPDATE collection\n" +
                "SET is_favourite = " + isFavourite + ", " +
                "rating = " + rating + ", " +
                "status = " + "'" + status + "', " +
                "review = " + "'" + review + "' " +
                "WHERE id = " + bookId + ";";
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
                Statement statement = con.createStatement()
                ) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("error updating");
        }
    }

    // getting a book from the database by id
    public static Book getBookById(int bookId) {
        String query = "SELECT * FROM collection\n" +
                "WHERE id = " + bookId + ";";
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
                Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery(query)
                ) {
            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String author = result.getString("author");
                int year = result.getInt("year");
                int coverID = result.getInt("cover_id");
                int rating = result.getInt("rating");
                String status = result.getString("status");
                String review = result.getString("review");
                boolean isFavourite = result.getInt("is_favourite") == 1;
                Book book = new Book(id, title, author, year, coverID);
                book.setRating(rating);
                book.setStatus(Book.Status.valueOf(status));
                book.setReview(review);
                book.setIsFavourite(isFavourite);
                return book;
            }
        } catch (SQLException e) {
            System.out.println("error getting book");
        }
        return null;
    }

    // getting all the books from the database
    public static BookCollection getBookCollection() {
        String query = "SELECT * FROM collection;";
        ArrayList<Book> collection = new ArrayList<>();
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
                Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery(query)
        ) {
            while (result.next()) {
                int id = result.getInt("id");
                String title = result.getString("title");
                String author = result.getString("author");
                int year = result.getInt("year");
                int coverID = result.getInt("cover_id");
                int rating = result.getInt("rating");
                String status = result.getString("status");
                String review = result.getString("review");
                boolean isFavourite = result.getInt("is_favourite") == 1;
                Book book = new Book(id, title, author, year, coverID);
                book.setRating(rating);
                book.setStatus(Book.Status.valueOf(status));
                book.setReview(review);
                book.setIsFavourite(isFavourite);
                collection.add(book);
            }
        } catch (SQLException e) {
            System.out.println("error getting collection");
        }
        return new BookCollection(collection);
    }

    // adding the selected to the database
    public static void addBook(String title, String author, int year, int coverID) {
        if (isNew(title, author, year)) {
            String query = "INSERT INTO collection (cover_id, title, author, year)" +
                    "VALUES (" + coverID + ", '" + title + "', '" + author + "', " + year + ");";
            try (
                    Connection con = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
                    Statement statement = con.createStatement()
            ) {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                System.out.println("error adding book");
            }
        } else {
            System.out.println("Book already exists in your collection");
        }
    }

    // preventing adding the same book more than once
    private static boolean isNew(String title, String author, int year) {
        Book currentBook = new Book(0, title, author, year, 0);
        for (Book book : AppView.collection.getMyCollection()) {
            if (currentBook.getTitle().equals(book.getTitle()) && currentBook.getAuthor().equals(book.getAuthor()) && currentBook.getYear() == book.getYear()) {
                return false;
            }
        }
        return true;
    }
}
