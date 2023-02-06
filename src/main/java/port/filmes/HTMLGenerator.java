package port.filmes;

import java.io.IOException;
import java.io.Writer;

public class HTMLGenerator {
    private final Writer writer;

    public HTMLGenerator(Writer writer) throws IOException {
        this.writer = writer;
        this.writer.write("<html>");
        this.writer.write("<head>");
        this.writer.write("<title>Lista de Filmes</title>");
        this.writer.write("</head>");
        this.writer.write("<body style='display:grid; text-align: center;'>");
        this.writer.write("<h1>Lista de Filmes</h1>");
    }

    public void generate(Content content) {
        try {
            this.writer.write("<div style='border: 1px solid black; margin: 2px; display: inline-block;'>");
            writer.write("<h1>" + content.title() + "</h1>");
            writer.write("<img width='500' height='500' src=\"" + content.urlImage() + "\"/>");
            writer.write("<p>" + content.rating() + "</p>");
            writer.write("<p>" + content.year() + "</p>");
            this.writer.write("</div>");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void close() throws IOException {
        this.writer.write("</body>");
        this.writer.write("</html>");
        this.writer.close();
    }
}
