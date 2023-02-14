package imbd.top250.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;


public class Series implements Content, Comparable<Series> {
    @JsonProperty("title")
    private String title;
    private String imageUrl;

    @JsonProperty("thumbnail")
    private JsonNode imageUrlNested;
    @JsonProperty("startYear")
    private String year;

    public void getImageUrl(){
        this.imageUrl = imageUrlNested.get("path").asText() + "." +imageUrlNested.get("extension").asText();
    }
    @Override
    public String title() {
        return title;
    }

    @Override
    public String imageUrl() {
        return imageUrl;
    }

    @Override
    public String year() {
        return year;
    }

    public Series() {

    }

    @Override
    public String type() {
        return "Series";
    }

    @Override
    public String toString() {
        return "Series{" +
                "title='" + title + '\'' +
                ", imageUrl='" + this.imageUrl + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public int compareTo(Series outro) {
        return this.title().compareTo(outro.title());
    }
}
