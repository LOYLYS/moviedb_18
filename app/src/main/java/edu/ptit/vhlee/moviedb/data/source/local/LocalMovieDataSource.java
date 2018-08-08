package edu.ptit.vhlee.moviedb.data.source.local;
import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.model.Movie;
import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;
public class LocalMovieDataSource implements MovieDataSource {

    @Override
    public ArrayList<Movie> getMoviesFromApi(String url, Callback<ArrayList<Movie>> callback) {
        return null;
    }

    @Override
    public Movie getMovieDetailFromApi(String url, Callback<Movie> callback) {
        return null;
    }
}