package port.filmes;

public record Movie(String title, String urlImage, String rating, Integer year) implements Content {
}
