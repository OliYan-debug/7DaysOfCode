package imbd.top250.Model;


public class Movie {
    private String rank;
    private String title;
    private String image;

    public Movie(){

    }

    public Movie(String rank, String title, String image) {
        this.rank = rank;
        this.title = title;
        this.image = image;
    }

    public String getRank() {
        return rank;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rank='" + rank + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
