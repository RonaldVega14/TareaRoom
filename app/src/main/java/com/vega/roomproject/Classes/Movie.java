package com.vega.roomproject.Classes;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "movie")
public class Movie {

    @PrimaryKey(autoGenerate = true)
    private int idMovie;

    @ColumnInfo (name = "nameMovie")
    private String nameMovie;

    @ColumnInfo (name = "descriptionMovie")
    private String descriptionMovie;

    @ColumnInfo (name = "nameCategory")
    private String nameCategory;

    @ColumnInfo (name = "nameStudio")
    private String nameStudio;

    //Constructor
    public Movie(){

    }

    public Movie(String nameMovie, String nameCategory, String nameStudio){
        this.nameMovie = nameMovie;
        this.nameCategory = nameCategory;
        this.nameStudio = nameStudio;
    }

    //Getters y setters

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getDescriptionMovie() {
        return descriptionMovie;
    }

    public void setDescriptionMovie(String descriptionMovie) {
        this.descriptionMovie = descriptionMovie;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNameStudio() {
        return nameStudio;
    }

    public void setNameStudio(String nameStudio) {
        this.nameStudio = nameStudio;
    }


}
