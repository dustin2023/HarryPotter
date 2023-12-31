package assignment.four_reflection_annotations;

import assignment.four_reflection_annotations.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;


/**
 * Copyright (c) 24.12.23, 08:30
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
        // TODO fetch a random book and print it to STDOUT
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.potterdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ICNDBApi service = retrofit.create(ICNDBApi.class);
        Call<Book> book = service.getRandomBook();
        Book s = book.execute().body();
        // Hier wird auf die BookData zugegriffen, um den Titel zu erhalten
        if (s != null && s.getData() != null && s.getData().getAttributes() != null) {
            logger.info("Book Title: {}", s.getData().getAttributes().getTitle());
            logger.info("Book Attributes: {}", s.getData().getAttributes());
        } else {
            logger.error("No valid data available.");
        }
    }
}
