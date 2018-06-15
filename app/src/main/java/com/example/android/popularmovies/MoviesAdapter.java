package com.example.android.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by Shubham on 6/14/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {


    List<GridItem> movies ;
    OnItemClickListener mListener;


    public MoviesAdapter(List<GridItem> movies, OnItemClickListener listener ){

        this.movies = movies;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);

        return new ViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GridItem movie = movies.get(position);
        holder.popularity.setText(String.valueOf(movie.getPopularity()) + "%");
        holder.movieTitle.setText(movie.getMovieTitle());
        holder.rating.setRating(movie.getRating());
        Picasso.with(holder.moviePoster.getContext()).load(movie.getImageUrl()).into(holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ViewHolder(View itemView) {
            super(itemView);
            movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
            moviePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
            popularity = (TextView) itemView.findViewById(R.id.popularity);
            rating = (RatingBar) itemView.findViewById(R.id.movie_rating);
            ((LinearLayout) moviePoster.getParent()).setOnClickListener(this);
        }
        public TextView movieTitle;
        public TextView popularity;
        public ImageView moviePoster;
        public RatingBar rating;

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mListener.onItemClicked(position);
        }
    }

public interface OnItemClickListener{
    void onItemClicked(int position);
}
}

