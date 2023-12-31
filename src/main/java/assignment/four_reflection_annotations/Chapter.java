/*
 * Copyright (c) 30.12.23, 19:42
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: Chapter.java
 *  <p>
 * Project-name: HarryPotter
 *
 */

package assignment.four_reflection_annotations;

import com.google.gson.annotations.SerializedName;

public class Chapter {
    @SerializedName("id")
    private String id;

    @SerializedName("type")
    private String type;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
