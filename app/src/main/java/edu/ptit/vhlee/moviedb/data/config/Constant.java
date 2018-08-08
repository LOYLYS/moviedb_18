package edu.ptit.vhlee.moviedb.data.config;

import edu.ptit.vhlee.moviedb.BuildConfig;

public interface Constant {

    interface Common {
        String LANGUAGE_ENG = "en-US";
        String TYPE_NOWPLAYING = "now_playing";
        String TYPE_TOP_RATE = "top_rated";
        String TYPE_UPCOMING = "upcoming";
        String URL_BASE = "https://api.themoviedb.org/3/movie/";
        String URL_KEY = "?api_key=";
        String URL_LANGUAGE = "&language=";
        String URL_PAGE = "&page=";
        String URL_IMAGE = "https://image.tmdb.org/t/p/w500/";
        String API_KEY = BuildConfig.API_KEY;
        String MSG_NO_RESULT = "Cannot load data";
        int NUM_SPAN = 3;
        int TOTAL_PAGE = 3;
    }

    interface JsonKey {
        String RESULT = "results";
        String ID = "id";
        String TITLE = "title";
        String POSTER_PATH = "poster_path";
        String RELEASE_DATE = "release_date";
        String OVERVIEW = "overview";
        String VOTE_AVERAGE = "vote_average";
        String VOTE_COUNT = "vote_count";
        String COMPANIES = "production_companies";
    }

    interface Url {
        String URL = Common.URL_BASE + "%s" + Common.URL_KEY
                + Common.API_KEY + Common.URL_LANGUAGE + "%s" + Common.URL_PAGE + "%d";
        String URL_DETAIL = Common.URL_BASE + "%s" + Common.URL_KEY
                + Common.API_KEY + Common.URL_LANGUAGE + "%s";
    }
}
