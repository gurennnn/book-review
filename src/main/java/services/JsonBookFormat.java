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

    @JsonProperty("author_name")
    public List<String> author_name;
}
