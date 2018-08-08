package edu.ptit.vhlee.moviedb.data.source.repository;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.model.Movie;
import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;
import edu.ptit.vhlee.moviedb.data.source.remote.MovieRemoteData;

public class MovieRepository {
    private MovieRemoteData mMovieRemoteData;

    public MovieRepository() {
        this.mMovieRemoteData = new MovieRemoteData();
    }

    public ArrayList<Movie> getMoviesFromRepo(String url, MovieDataSource.Callback callback) {
        return mMovieRemoteData.getMoviesFromApi(url, callback);
    }

    public Movie getMovieDetailFromRepo(String url, MovieDataSource.Callback callback) {
        return mMovieRemoteData.getMovieDetailFromApi(url, callback);
    }
}
