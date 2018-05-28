package com.vega.roomproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vega.roomproject.Adapter.MoviesAdapter;
import com.vega.roomproject.Classes.AppDatabase;
import com.vega.roomproject.Classes.Movie;
import com.vega.roomproject.R;

import java.util.List;

/**
 * Created by UCA on 24/05/2018.
 */

public class CreateMovie extends AppCompatActivity {

    private Movie movie;
    private List<Movie> movies;
    private MoviesAdapter adapter;
    private RecyclerView recyclerView;
    private EditText movieNameET, studioNameET, categoryNameET;
    private Button submit;
    private String movieNameS, studioNameS, categoryNameS;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_movie);

        movieNameET = findViewById(R.id.ETMovieN);
        studioNameET = findViewById(R.id.ETStudio);
        categoryNameET = findViewById(R.id.ETCategory);
        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!movieNameET.getText().toString().equals("")){
                    movieNameS = movieNameET.getText().toString();
                }else{
                    movieNameS = "N/A";
                }
                if(!studioNameET.getText().toString().equals("")){
                    studioNameS = studioNameET.getText().toString();
                }else{
                    studioNameS = "N/A";
                }
                if(!categoryNameET.getText().toString().equals("")){
                    categoryNameS = categoryNameET.getText().toString();
                }else{
                    categoryNameS = "N/A";
                }

                AppDatabase db = AppDatabase.getAppDatabase(getApplicationContext());
                db.moviesDAO().insertMovie(new Movie(movieNameS,studioNameS,categoryNameS));
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
}
