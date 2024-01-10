package assignment.four_reflection_annotations.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Copyright (c) 24-24.12.23, 09:58
 * Since: Dezember 2023
 * <p>
 * Author: dustin
 * <p>
 * Name: Book.java
 * <p>
 * Project-name: HarryPotter
 */
// Lombok: Nach Hinzufügen der Lombok-Annotationen können toString(), equals(), und hashCode() für Book entfernt werden, da Lombok sie automatisch generiert
public final class Book {
    private BookData data;
    private final String id;
    private final BookAttributes attributes;
    private final BookRelationships relationships;


    public Book(BookData data) {
        this.id = "-1";
        this.data = data;
        this.attributes = new BookAttributes();
        this.relationships = new BookRelationships();
    }

    public BookData getData() {
        return data;
    }

    public String getId() {
        return id;
    }

    public BookAttributes getAttributes() {
        return attributes;
    }

    public BookRelationships getRelationships() {
        return relationships;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(data, book.data) && Objects.equals(id, book.id) && Objects.equals(attributes, book.attributes) && Objects.equals(relationships, book.relationships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, id, attributes, relationships);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", attributes=" + attributes +
                ", relationships=" + relationships +
                '}';
    }
}
