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
class ICNDBTests {

    private static final Logger logger = LogManager.getLogger(ICNDBTests.class);

    private PotterApiService icndbApi;

    @BeforeEach
    void setup() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.potterdb.com")
                .build();

        icndbApi = retrofit.create(PotterApiService.class);
    }

//    @Test
//    void testToString() {
//        Book book = new Book();
//        book.setId("123");
//        book.setAttributes(new BookAttributes());
//        //book.getAttributes().setTitle("Test Title");
//
//        String expectedToString = "Book{id='123', data=null, attributes=BookAttributes{slug='null', author='null', cover='null', dedication='null', pages=0, releaseDate='null', summary='null', title='null', wiki='null'}, relationships=null}";
//        assertEquals(expectedToString, book.toString());
//    }

	@Test
	void testGetBookByQuery() throws IOException {
		Book[] j = icndbApi.getBookByQuery("Stone").execute().body().getBooks();
		assertNotNull(j);
		assertTrue(j.length > 0);
	}

    @Test
    void testGetRandomBooks() throws IOException {
        Book book = icndbApi.getRandomBook().execute().body();
        assertNotNull(book);
    }
}