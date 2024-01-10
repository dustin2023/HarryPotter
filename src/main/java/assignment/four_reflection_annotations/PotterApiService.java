package assignment.four_reflection_annotations;


import assignment.four_reflection_annotations.model.Book;
import assignment.four_reflection_annotations.model.Books;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Copyright (c) 24.12.23, 08:30
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: ICNDBApi.java
 *  <p>
 * Project-name: HarryPotter
 *
 */
public interface PotterApiService {

    @GET("/v1/books/random")
    Call<Book> getRandomBook();

    @GET("/v1/books")
    Call<Books> getBookByQuery(@Query("filter[title_cont]") String title);

    @GET("/v1/books")
    Call<Books> getAllBooks();
}
