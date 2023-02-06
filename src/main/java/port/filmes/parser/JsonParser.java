package port.filmes.parser;

import port.filmes.Content;

import java.util.ArrayList;
import java.util.List;

public abstract class JsonParser {
    protected String json;
    protected List<Content> list = new ArrayList<>();

    abstract public List<Content> parse();
}
