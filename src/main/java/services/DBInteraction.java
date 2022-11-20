package services;

import models.Book;
import models.BookCollection;
import viewmodels.AppView;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DBInteraction {

    // getting a book from the database by id
    public static Book getBookById(int bookId) {
        String query = "SELECT * FROM collection\n" +
                "WHERE id = " + bookId + ";";
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ASUS\\IdeaProjects\\book-review\\src\\main\\resources\\data\\BookReviewDB.db");
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
                boolean isFavourite = result.getInt("is_favourite") == 1 ? true : false;
                Book book = new Book(id, title, author, year, coverID);
                book.setRating(rating);
                book.setStatus(Book.Status.valueOf(status));
                book.setReview(review);
                book.setIsFavourite(isFavourite);
                return book;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // getting all the books from the database
    public static BookCollection getBookCollection() {
        String query = "SELECT * FROM collection;";
        ArrayList<Book> collection = new ArrayList<>();
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ASUS\\IdeaProjects\\book-review\\src\\main\\resources\\data\\BookReviewDB.db");
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
                boolean isFavourite = result.getInt("is_favourite") == 1 ? true : false;
                Book book = new Book(id, title, author, year, coverID);
                book.setRating(rating);
                book.setStatus(Book.Status.valueOf(status));
                book.setReview(review);
                book.setIsFavourite(isFavourite);
                collection.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new BookCollection(collection);
    }

    // adding the selected to the database
    public static void addBook(String title, String author, int year, int coverID) {
        if (isNew(title, author, year)) {
            String query = "INSERT INTO collection (cover_id, title, author, year)" +
                    "VALUES (" + coverID + ", '" + title + "', '" + author + "', " + year + ");";
            try (
                    Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ASUS\\IdeaProjects\\book-review\\src\\main\\resources\\data\\BookReviewDB.db");
                    Statement statement = con.createStatement()
            ) {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
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
