package movie.src;

public class MovieManagerImpl implements IMovieManager {
    private static final int MAX_SIZE = 100;
    private Movie[] movieList = new Movie[MAX_SIZE];
    int size = 0;
    private static final MovieManagerImpl instance = new MovieManagerImpl();

    private MovieManagerImpl() {

    }

    public static MovieManagerImpl getInstance() {
        return instance;
    }

    public void add(Movie movie) {
        if (size < MAX_SIZE) {
            for (int i = 0; i < MAX_SIZE; i++) {
                if (movieList[i] == null) {
                    movieList[i] = movie;
                    size += 1;
                    return;
                }
            }
        }
    }

    public Movie[] getList() {
        Movie[] result = new Movie[size];

        int idx = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (movieList[i] != null) {
                result[idx] = movieList[i];
                idx += 1;
            }
        }

        return result;
    }

    public Movie[] getMovies() {
        Movie[] movies = getList();

        int cnt = 0;
        for (Movie movie : movies) {
            if (!(movie instanceof SeriesMovie)) {
                cnt += 1;
            }
        }

        Movie[] result = new Movie[cnt];
        int idx = 0;
        for (Movie movie : movies) {
            if (!(movie instanceof SeriesMovie)) {
                result[idx] = movie;
                idx += 1;
            }
        }
        return result;
    }

    public SeriesMovie[] getSeriesMovies() {
        Movie[] movies = getList();

        int cnt = 0;
        for (Movie movie : movies) {
            if (movie instanceof SeriesMovie) {
                cnt += 1;
            }
        }

        SeriesMovie[] result = new SeriesMovie[cnt];
        int idx = 0;

        for (Movie movie : movies) {
            if (movie instanceof SeriesMovie) {
                result[idx] = (SeriesMovie) movie;
                idx += 1;
            }
        }
        return result;
    }

    public Movie[] searchByTitle(String title) {
        Movie[] movies = getList();

        int cnt = 0;
        for (Movie movie : movies) {
            if (movie.getTitle().contains(title)) {
                cnt += 1;
            }
        }

        Movie[] result = new Movie[cnt];
        int idx = 0;
        for (Movie movie : movies) {
            if (movie.getTitle().contains(title)) {
                result[idx] = movie;
                idx += 1;
            }
        }

        return result;
    }

    public double getRunningTimeAvg() {
        Movie[] movies = getList();

        double sum = 0;
        for (Movie movie : movies) {
            sum += movie.getRunningTime();
        }

        return sum / movies.length;
    }
}
