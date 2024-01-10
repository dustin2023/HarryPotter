package assignment.four_reflection_annotations.tests;


import assignment.four_reflection_annotations.PotterApiService;
import assignment.four_reflection_annotations.model.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Copyright (c) 24-24.12.23, 08:30
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: ICNDBTests.java
 * <p>
 * Project-name: HarryPotter
 */
class PotterApiTests {

    private static final Logger logger = LogManager.getLogger(PotterApiTests.class);

    private PotterApiService potterApi;

    @BeforeEach
    void setup() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.potterdb.com")
                .build();

        potterApi = retrofit.create(PotterApiService.class);
    }

    @Test
    void testGetRandomBooks() throws IOException {
        Book book = potterApi.getRandomBook().execute().body();
        assertNotNull(book);
    }
}