package assignment.four_reflection_annotations.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

/**
 * Copyright (c) 24.12.23, 08:30
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Books.java
 * <p>
 * Project-name: HarryPotter
 */
public class Books {
   // @SerializedName("data")
    private Book[] data;

    public Book[] getBooks() {
        return data;
    }
}