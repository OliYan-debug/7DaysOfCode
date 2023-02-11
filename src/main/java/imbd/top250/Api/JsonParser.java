package imbd.top250.Api;

import imbd.top250.Model.Content;

import java.util.List;

public interface JsonParser {
    public List<? extends Content> parse();
    public String type();
}
