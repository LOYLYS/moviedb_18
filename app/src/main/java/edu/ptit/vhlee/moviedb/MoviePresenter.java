package edu.ptit.vhlee.moviedb;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.model.Movie;
import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;
import edu.ptit.vhlee.moviedb.data.source.repository.MovieRepository;

public class MoviePresenter implements MovieContract.Presenter {
    private MovieContract.View mView;
    private MovieRepository mMovieRepository;

    public MoviePresenter(MovieContract.View view) {
        this.mMovieRepository = new MovieRepository();
        this.mView = view;
    }

    @Override
    public ArrayList<Movie> getMovies(String url) {
        return mMovieRepository.getMoviesFromRepo(url,
                new MovieDataSource.Callback<ArrayList<Movie>>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(ArrayList<Movie> movies) {
                        mView.showSuccess(movies);
                    }

                    @Override
                    public void onFail(Exception exception) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public Movie getMovieDetail(String url) {
        return mMovieRepository.getMovieDetailFromRepo(url,
                new MovieDataSource.Callback<Movie>() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(Movie movie) {
                        mView.showMovie(movie);
                    }

                    @Override
                    public void onFail(Exception exception) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
