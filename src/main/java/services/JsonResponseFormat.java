package services;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class JsonResponseFormat {
    @JsonProperty("numFound")
    public int numFound;

    @JsonProperty("start")
    public int start;

    @JsonProperty("numFoundExact")
    public boolean numFoundExact;

    @JsonProperty("docs")
    public List<JsonBookFormat> docs;

    @JsonProperty("num_found")
    public int num_found;

    @JsonProperty("q")
    public String q;

    @JsonProperty("offset")
    public Object offset;

    @Override
    public String toString() {
        return "{\n" +
                "numFound: " + numFound + ",\n" +
                "start: " + start + ",\n" +
                "numFoundExact" + numFoundExact + ",\n" +
                "doc: " + docs.toString() +",\n" +
                "num_found: " + num_found + ",\n" +
                "q: " + q + ",\n" +
                "offset: " + offset + "\n" +
                "}";
    }
}
