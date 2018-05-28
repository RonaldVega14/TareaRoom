package com.vega.roomproject.Interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.vega.roomproject.Classes.Movie;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface MoviesDAO {

    @Query("SELECT * FROM movie")
    List<Movie> getAll();

    @Insert(onConflict = REPLACE)
    void insertMovie(Movie movie);

}
