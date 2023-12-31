/*
 * Copyright (c) 30.12.23, 19:39
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: BookResponse.java
 *  <p>
 * Project-name: HarryPotter
 *
 */

package assignment.four_reflection_annotations;

import com.google.gson.annotations.SerializedName;

public class BookResponse {
    @SerializedName("data")
    private BookData data;

    public BookData getData() {
        return data;
    }
}
