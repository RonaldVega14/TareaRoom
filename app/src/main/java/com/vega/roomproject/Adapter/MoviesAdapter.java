package com.vega.roomproject.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vega.roomproject.Classes.Movie;
import com.vega.roomproject.R;

import java.util.List;

/**
 * Created by Ronald Vega on 24/05/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private Movie movie;
    private List<Movie> movies;
    private Context context;


    public static class MoviesViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView movieName, studioName, categoryName;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            movieName = itemView.findViewById(R.id.ETMovieN);
            studioName = itemView.findViewById(R.id.ETStudio);
            categoryName = itemView.findViewById(R.id.ETCategory);
        }
    }

    public MoviesAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    public MoviesAdapter(List<Movie> movies, Context context){
        this.movies = movies;
        this.context = context;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        return (new MoviesViewHolder(view));
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        holder.movieName.setText(movies.get(position).getNameMovie());
        holder.studioName.setText(movies.get(position).getNameStudio());
        holder.categoryName.setText(movies.get(position).getNameCategory());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}
