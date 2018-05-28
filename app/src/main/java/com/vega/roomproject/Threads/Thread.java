package com.vega.roomproject.Threads;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.vega.roomproject.Adapter.MoviesAdapter;
import com.vega.roomproject.Classes.AppDatabase;
import com.vega.roomproject.Classes.Movie;

import java.util.List;

/**
 * Created by Ronald Vega on 26/05/2018.
 */

public class Thread extends AsyncTask {
    private List<Movie> movies;
    private RecyclerView recyclerView;
    private MoviesAdapter adapter;
    private AppDatabase db;

    public Thread(List<Movie> movies, RecyclerView recyclerView, MoviesAdapter adapter, AppDatabase db){
        this.movies = movies;
        this.recyclerView = recyclerView;
        this.adapter = adapter;
        this.db = db;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        addMovie(movies);
        adapter = new MoviesAdapter(movies);
        recyclerView.setAdapter(adapter);
        return null;
    }

    public void addMovie(List<Movie> movies){
        movies.add(new Movie("Valerian", "Sci-Fi", "Madhouse"));
        movies.add(new Movie("Mama mia","Drama","IDK"));
    }
}
