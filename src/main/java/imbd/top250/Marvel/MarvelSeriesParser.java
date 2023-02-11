package imbd.top250.Marvel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import imbd.top250.Api.JsonParser;
import imbd.top250.Model.Series;

import java.util.List;

public class MarvelSeriesParser implements JsonParser {
    private static final ObjectMapper mapper = new ObjectMapper();
    private String jsonString;

    public MarvelSeriesParser(String jsonString){
        this.jsonString = jsonString;
    }
    public List<Series> parse(){
        try {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode jsonNode = mapper.readTree(this.jsonString);
            String arrayJsonFull = jsonNode.get("data").get("results").toString();
            List<Series> series = mapper.readValue(arrayJsonFull, new TypeReference<List<Series>>(){});
            for(Series content : series){
                content.getImageUrl();
            }
            return series;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public String type() {
        return "Series";
    }
}
