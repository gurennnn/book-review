package services;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonBookFormat {
    @JsonProperty("title")
    public String title;

    @JsonProperty("edition_count")
    public int edition_count;


    @JsonProperty("first_publish_year")
    public int first_publish_date;

    @JsonProperty("cover_i")
    public int cover_i;

    @JsonProperty("author_name")
    public List<String> author_name;

    @Override
    public String toString() {
        return "{\n" +
                "\ttitle: " + title + ",\n" +
                "\tedition_count: " + edition_count + ",\n" +
                "\tfirst_publish_year: " + first_publish_date + ",\n" +
                "\tcover_i: " + cover_i + ",\n" +
                "\tauthor_name: " + author_name.toString() + "\n" +
                "}";
    }
}
