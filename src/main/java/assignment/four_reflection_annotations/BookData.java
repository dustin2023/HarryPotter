/*
 * Copyright (c) 30.12.23, 19:39
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: BookData.java
 *  <p>
 * Project-name: HarryPotter
 *
 */

package assignment.four_reflection_annotations;

import assignment.four_reflection_annotations.model.BookAttributes;
import com.google.gson.annotations.SerializedName;

public class BookData {

    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    @SerializedName("attributes")
    private BookAttributes attributes;

    @SerializedName("relationships")
    private BookRelationships relationships;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BookAttributes getAttributes() {
        return attributes;
    }

    public BookRelationships getRelationships() {
        return relationships;
    }
}
