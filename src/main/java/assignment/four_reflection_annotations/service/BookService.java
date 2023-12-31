package assignment.four_reflection_annotations.service;

import assignment.four_reflection_annotations.PotterApiService;
import assignment.four_reflection_annotations.model.Book;
import assignment.four_reflection_annotations.model.Books;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 * Copyright (c) 31.12.23, 14:08
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: BookService.java
 * <p>
 * Project-name: HarryPotter
 */
public class BookService {
    private final Retrofit retrofit;

    public BookService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public Book getRandomBook() throws IOException {
        PotterApiService service = retrofit.create(PotterApiService.class);
        Call<Book> bookCall = service.getRandomBook();
        return bookCall.execute().body();
    }

    public Response<Books> getAllBooks() throws IOException {
        PotterApiService service = retrofit.create(PotterApiService.class);
        Call<Books> bookCall = service.getAllBooks();
        return bookCall.execute();
    }

//    public Books getBookByQuery(String query) throws IOException {
//        PotterApiService service = retrofit.create(PotterApiService.class);
//        Call<Books> bookCall = service.getBookByQuery(query);
//        return bookCall.execute().body();
//    }
}
