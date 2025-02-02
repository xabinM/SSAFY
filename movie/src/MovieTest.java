package movie.src;

import java.util.Arrays;

public class MovieTest {
    public static void main(String[] args) {
        Movie m1 = new SeriesMovie(1, "Lord of The Ring", "Peter Jackson", "Fantasy", 180, 1, "The Fellowship of the Ring");
        Movie m2 = new SeriesMovie(2, "Harry Potter", "Christopher Columbus", "Fantasy", 150, 1, "Sorcerer's Stone");
        Movie m3 = new SeriesMovie(3, "Harry Potter", "Christopher Columbus", "Fantasy", 150, 2, "the Chamber of Secrets");
        Movie m4 = new SeriesMovie(4, "Lord of The Ring", "Peter Jackson", "Fantasy", 180, 2, "The Two Towers");
        Movie m5 = new Movie(5, "The Intern", "Nancy Meyers", "Comedy", 120);

        MovieManagerImpl mm = MovieManagerImpl.getInstance();

        mm.add(m1);
        mm.add(m2);
        mm.add(m3);
        mm.add(m4);
        mm.add(m5);

        System.out.println("***************전체 영화 목록***************");
        System.out.println(Arrays.toString(mm.getList()));

        System.out.println("******************일반 영화 목록*******************");
        System.out.println(Arrays.toString(mm.getMovies()));

        System.out.println("******************시리즈 영화 목록*******************");
        System.out.println(Arrays.toString(mm.getSeriesMovies()));

        System.out.println("*****************영화 제목으로 영화 찾기****************");
        System.out.println(Arrays.toString(mm.searchByTitle("Lord")));

        System.out.println("*****************전체 영화 러닝타임 평균****************");
        System.out.println(mm.getRunningTimeAvg());
    }

}
