package edu.ptit.vhlee.moviedb.data.source;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.config.DataCallback;
import edu.ptit.vhlee.moviedb.data.model.Movie;

public interface MovieDataSource extends DataCallback {
    ArrayList<Movie> getMoviesFromApi(String url, Callback<ArrayList<Movie>> callback);

    Movie getMovieDetailFromApi(String url, Callback<Movie> callback);
}
