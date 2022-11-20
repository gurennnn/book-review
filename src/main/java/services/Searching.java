package services;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import models.BookSearch;

public class Searching {

    // getting the list of books from the search result's json object with title author, and date
    public static List<BookSearch> getBookSearchList(String title) {
        // getting the Json Response from title search
        JsonResponseFormat jsonResponse = transformToJsonFormat(title);
        if (jsonResponse == null) return null;
        // populating our list with the 10 first books from the search results
        List<BookSearch> bookSearchList = new ArrayList<>();
        int counter = 0;
        for (JsonBookFormat jsonBook : jsonResponse.docs) {
            if (counter > 10) break;
            String bookAuthor = jsonBook.author_name == null ? "unknown" : jsonBook.author_name.get(0);
            bookSearchList.add(new BookSearch(jsonBook.title, bookAuthor, jsonBook.first_publish_date, jsonBook.cover_i));
            counter++;
        }
        return bookSearchList;
    }

    // converting the json String to a java object
    public static JsonResponseFormat transformToJsonFormat(String title) {
        try {
            String jsonString = getJsonResponse(title);
            if (jsonString == null) return null;
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonString, JsonResponseFormat.class);
        } catch (IOException e) {
            return null;
        }
    }

    // getting the json response as a String
    public static String getJsonResponse(String title) throws IOException {
        String stringURL = urlBuilder(title);
        // building the url
        if (stringURL == null) return null;
        URL url = new URL(stringURL);
        // establishing the connection with the url and connection properties
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        // if request failed
        int status = con.getResponseCode();
        if (status > 299) {
            con.disconnect();
            return null;
        }
        // getting the response from the request
        Reader streamReader = new InputStreamReader(con.getInputStream());
        BufferedReader in = new BufferedReader(streamReader);
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }

    // URL builder method
    public static String urlBuilder(String bookTitle) {
        // splitting title with space characters
        bookTitle = bookTitle.trim().toLowerCase();
        String[] titleParts = bookTitle.split(" +", 0);
        String url = "http://openlibrary.org/search.json?title=";
        int length = titleParts.length;
        // if title isn't valid valid
        if (length == 1 && titleParts[0].equals("")) {
            return null;
        }
        for (int i = 0; i < length - 1; i++) {
            url += titleParts[i]  + "+";
        }
        url += titleParts[length-1] + "&fields=cover_i,edition_count,title,author_name,first_publish_year&sort=editions";
        return url;
    }

}
