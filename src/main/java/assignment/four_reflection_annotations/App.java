package assignment.four_reflection_annotations;

import assignment.four_reflection_annotations.model.Book;
import assignment.four_reflection_annotations.model.BookData;
import assignment.four_reflection_annotations.model.Books;
import assignment.four_reflection_annotations.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import retrofit2.Response;
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

        BookService bookService = new BookService(retrofit);
        try {
            // random Book by Title
            Book book = bookService.getRandomBook();
            logger.info("Book Title: {}", book.getData().getAttributes().getTitle());

            // all Books with specific Query in Title
            Book[] booksWithSpecificTitle = bookService.getBookByQuery("Stone").getBooks();
            if (booksWithSpecificTitle.length == 0) {
                logger.error("No books found.");
            } else {
                logger.info("Books found: {}", booksWithSpecificTitle.length);
            }

            logger.info("Books with specific Query in Title: ");
            for (Book b : booksWithSpecificTitle) {
                logger.info("Book Title: {}", b.getAttributes().getTitle());
            }


            // all Books with all Attributes
            Response<Books> booksResponse = bookService.getAllBooks();
            if (booksResponse.isSuccessful()) {
                Books books = booksResponse.body();
                // TODO: Error handling
                Book[] booksData = books.getBooks();
                for (int i = 0; i < booksData.length; i++) {
                    logger.info("{}. Book Title: {}", i + 1, booksData[i]);
                }

                // count Books
                int countBooks = booksData.length;
                logger.info("length: {}", countBooks);
            } else {
                logger.error("Error fetching books. Response code: {}", booksResponse.code());
            }
        } catch (IOException e) {
            logger.error("Error fetching random book: {}", e.getMessage());
        }
    }
}
