package bookmyshow.entities;

public class Movie {
    private int movieId;
    private String title;
    private int duration;

    public Movie(int movieId, String title, int duration) {
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
