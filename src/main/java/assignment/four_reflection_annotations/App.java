package assignment.four_reflection_annotations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Copyright (c) 31-31.12.23, 14:08
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: App.java
 * <p>
 * Project-name: HarryPotter
 */
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.potterdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
