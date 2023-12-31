/*
 * Copyright (c) 30-30.12.23, 19:41
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: BookAttributes.java
 *  <p>
 * Project-name: HarryPotter
 *
 */

package assignment.four_reflection_annotations.model;

import com.google.gson.annotations.SerializedName;


public class BookAttributes {
    @SerializedName("slug")
    private String slug;

    @SerializedName("author")
    private String author;

    @SerializedName("cover")
    private String cover;

    @SerializedName("dedication")
    private String dedication;

    @SerializedName("pages")
    private int pages;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("summary")
    private String summary;

    @SerializedName("title")
    private String title;

    @SerializedName("wiki")
    private String wiki;

    public String getSlug() {
        return slug;
    }

    public String getAuthor() {
        return author;
    }

    public String getCover() {
        return cover;
    }

    public String getDedication() {
        return dedication;
    }

    public int getPages() {
        return pages;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }

    public String getWiki() {
        return wiki;
    }
}
