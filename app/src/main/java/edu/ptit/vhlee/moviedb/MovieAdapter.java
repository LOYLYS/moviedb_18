package edu.ptit.vhlee.moviedb;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.ptit.vhlee.moviedb.data.config.Constant;
import edu.ptit.vhlee.moviedb.data.model.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context mContext;
    private final ArrayList<Movie> mMovies;
    private final ItemClickListener mListener;

    public MovieAdapter(Context mContext, ItemClickListener listener) {
        this.mContext = mContext;
        this.mMovies = new ArrayList<>();
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_recycler, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.setData(mMovies.get(position));
        holder.bindView(mMovies.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mMovies != null ? mMovies.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageBackdrop;
        private TextView mTextTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageBackdrop = itemView.findViewById(R.id.image_poster);
            mTextTitle = itemView.findViewById(R.id.text_movie_name);
        }

        private void setData(Movie movie) {
            mTextTitle.setText(movie.getTitle());
            Picasso.with(mContext)
                    .load(Constant.Common.URL_IMAGE + movie.getBackdropPath())
                    .into(mImageBackdrop);
        }


        private void bindView(final Movie movie, final ItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.setListener(movie);
                }
            });
        }
    }

    public void addData(ArrayList<Movie> movies) {
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }
    public interface ItemClickListener {
        void setListener(Object object);
    }
}
