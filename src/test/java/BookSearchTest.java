import org.junit.Before;
import org.junit.Test;
import services.Searching;

import java.io.IOException;

import static  org.junit.Assert.*;

public class BookSearchTest {
    String url1, url2, url3;
    String _url = "http://openlibrary.org/search.json?title=";
    String url_ = "&fields=cover_i,edition_count,title,author_name,first_publish_year&sort=editions";
    @Before
    public void initialize() {
        url1 = Searching.urlBuilder("");
        url2 = Searching.urlBuilder("un Temps Fou");
        url3 = Searching.urlBuilder("  un   temps fou    ");
    }

    @Test
    public void testURLBuilder() {
        assertNull(url1);
        assertEquals(_url + "un+temps+fou" + url_, url2);
        assertEquals(_url + "un+temps+fou" + url_, url3);
    }

    @Test
    public void testGetJsonResponse() throws IOException {
        assertNull(Searching.getJsonResponse(url1));
    }
}
