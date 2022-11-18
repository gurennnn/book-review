package services;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonResponseFormat {
    @JsonProperty("numFound")
    public int numFound;

    @JsonProperty("start")
    public int start;

    @JsonProperty("numFoundExact")
    public boolean exact;

    @JsonProperty("docs")
    public List<JsonBookFormat> docs;

    @JsonProperty("num_found")
    public int num_found;

    @JsonProperty("q")
    public String q;

    @JsonProperty("offset")
    public Object offset;
}
