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
        try {
            Retrofit retrofit = createRetrofitInstance();
            BookService bookService = new BookService(retrofit);

            displayRandomBookTitle(bookService);

            findBooksBySpecificQuery(bookService);

            displayAllBooks(bookService);

        } catch (IOException e) {
            logger.error("Error fetching random book: {}", e.getMessage());
        }
    }

    private static Retrofit createRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl("https://api.potterdb.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static void displayRandomBookTitle(BookService bookService) throws IOException {
        Book book = bookService.getRandomBook();
        logger.info("Random Book Title: {}", book.getData().getAttributes().getTitle());
    }

    private static void findBooksBySpecificQuery(BookService bookService) throws IOException {
        Book[] booksWithSpecificTitle = bookService.getBookByQuery("Stone").getBooks();
        if (booksWithSpecificTitle.length == 0) {
            logger.error("No books found with the specific query.");
        } else {
            logger.info("Books found with specific query in Title: {}", booksWithSpecificTitle.length);
            for (Book b : booksWithSpecificTitle) {
                logger.info("Book Title: {}", b.getAttributes().getTitle());
            }
        }
    }

    private static void displayAllBooks(BookService bookService) throws IOException {
        Response<Books> booksResponse = bookService.getAllBooks();
        if (booksResponse.isSuccessful()) {
            Books books = booksResponse.body();
            if (books != null && books.getBooks() != null) {
                Book[] booksData = books.getBooks();

                logger.info("All Books: ");
                for (int i = 0; i < booksData.length; i++) {
                    logger.info("{}. Book Title: {}", i + 1, booksData[i].getAttributes().getTitle());
                }
                logger.info("Total number of books: {}", booksData.length);
            } else {
                logger.error("No books data available.");
            }
        } else {
            logger.error("Error fetching books. Response code: {}", booksResponse.code());
        }
    }
}
