/*
 * Copyright (c) 30-31.12.23, 14:07
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: BookData.java
 *  <p>
 * Project-name: HarryPotter
 *
 */

package assignment.four_reflection_annotations.model;

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
