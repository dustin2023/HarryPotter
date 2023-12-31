package assignment.four_reflection_annotations.model;


import assignment.four_reflection_annotations.BookData;
import assignment.four_reflection_annotations.BookRelationships;
import lombok.Data;

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
@Data // Lombok: Nach Hinzufügen der Lombok-Annotationen können toString(), equals(), und hashCode() für Book entfernt werden, da Lombok sie automatisch generiert
public final class Book {
    private BookData data;

    public BookData getData() {
        return data;
    }

    public void setData(BookData data) {
        this.data = data;
    }


    private String id;
    private BookAttributes attributes;
    private BookRelationships relationships;

    public Book() {
        this.id = "-1";
        this.attributes = new BookAttributes();
        this.relationships = new BookRelationships();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BookAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(BookAttributes attributes) {
        this.attributes = attributes;
    }

    public BookRelationships getRelationships() {
        return relationships;
    }

    public void setRelationships(BookRelationships relationships) {
        this.relationships = relationships;
    }
}
