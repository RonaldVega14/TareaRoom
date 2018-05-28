package com.vega.roomproject.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vega.roomproject.Adapter.MoviesAdapter;
import com.vega.roomproject.Classes.AppDatabase;
import com.vega.roomproject.Classes.Movie;
import com.vega.roomproject.R;
import com.vega.roomproject.Threads.Thread;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MoviesAdapter adapter;
    List<Movie> movies;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.movie_recycler);
        adapter = new MoviesAdapter(movies, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        AppDatabase db = AppDatabase.getAppDatabase(getApplicationContext());
        movies = db.moviesDAO().getAll();

        Thread thread = new Thread(movies, recyclerView, adapter, db);
        thread.execute();
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(getApplicationContext(), CreateMovie.class));
            }
        });

    }
}
