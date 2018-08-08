package edu.ptit.vhlee.moviedb.data.source.remote;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.config.Constant;
import edu.ptit.vhlee.moviedb.data.model.Movie;
import edu.ptit.vhlee.moviedb.data.source.MovieDataSource;

public class MovieRemoteData implements MovieDataSource {
    @Override
    public ArrayList<Movie> getMoviesFromApi(String url, final Callback<ArrayList<Movie>> callback) {
        final ArrayList<Movie> mMovies = new ArrayList<>();
        new BaseAsyncTask(new Callback<String>() {
            @Override
            public void onStart() {
                callback.onStart();
            }

            @Override
            public void onSuccess(String data) {
                Movie.Builder builder = new Movie.Builder();
                try {
                    JSONObject jsonObject = new JSONObject(data);
                    JSONArray arrJsonArrays = jsonObject.getJSONArray(Constant.JsonKey.RESULT);
                    for (int i = 0; i < arrJsonArrays.length(); i++) {
                        JSONObject arr = arrJsonArrays.getJSONObject(i);
                        Movie movie = builder.setId(arr.getString(Constant.JsonKey.ID))
                                .setTitle(arr.getString(Constant.JsonKey.TITLE))
                                .setBackdropPath(arr.getString(Constant.JsonKey.POSTER_PATH))
                                .build();
                        mMovies.add(movie);
                    }
                    callback.onSuccess(mMovies);
                } catch (JSONException e) {
                    callback.onFail(e);
                }
            }

            @Override
            public void onFail(Exception exception) {
                callback.onFail(exception);
            }

            @Override
            public void onComplete() {
                callback.onComplete();
            }
        }).execute(url);
        return mMovies;
    }

    @Override
    public Movie getMovieDetailFromApi(String url, final Callback<Movie> callback) {
        final Movie.Builder builder = new Movie.Builder();
        new BaseAsyncTask(new Callback<String>() {
            @Override
            public void onStart() {

            }

            @Override
            public void onSuccess(String data) {
                try {
                    JSONObject movieObject = new JSONObject(data);
                    builder.setTitle(movieObject.getString(Constant.JsonKey.TITLE))
                            .setBackdropPath(movieObject.getString(Constant.JsonKey.POSTER_PATH))
                            .setReleaseDate(movieObject.getString(Constant.JsonKey.RELEASE_DATE))
                            .setOverView(movieObject.getString(Constant.JsonKey.OVERVIEW))
                            .setVoteAverage(movieObject.getString(Constant.JsonKey.VOTE_AVERAGE))
                            .setVoteCount(movieObject.getString(Constant.JsonKey.VOTE_COUNT))
                            .build();
                    callback.onSuccess(new Movie(builder));
                } catch (JSONException e) {
                    callback.onFail(e);
                }
            }

            @Override
            public void onFail(Exception exception) {

            }

            @Override
            public void onComplete() {

            }
        }).execute(url);
        return new Movie(builder);
    }
}
