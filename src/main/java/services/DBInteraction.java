package services;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class DBInteraction {

    public static void addBook(String title, String author, int year) {
        try (
                Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ASUS\\IdeaProjects\\book-review\\src\\main\\resources\\data\\BookReviewDB.db");
                Statement statement = con.createStatement()
                ) {
            String query = "INSERT INTO collection (title, author, year)" +
                    "VALUES ('" + title + "', '" + author + "', " + year + ");";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
