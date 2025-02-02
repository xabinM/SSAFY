package movie.src;

public interface IMovieManager {
    public void add(Movie movie);

    public Movie[] getList();

    public Movie[] searchByTitle(String title);

    public Movie[] getMovies();

    public SeriesMovie[] getSeriesMovies();

    public double getRunningTimeAvg();
}
