package edu.ptit.vhlee.moviedb;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.model.Movie;

public interface MovieContract {
    interface Presenter {
        ArrayList<Movie> getMovies(String url);
        Movie getMovieDetail(String url);
    }

    interface View {
        void showNoResult(ArrayList<Movie> movies, Exception ex);

        void showSuccess(ArrayList<Movie> movies);

        void showMovie(Movie movie);
    }
}
