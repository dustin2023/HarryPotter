/*
 * Copyright (c) 30.12.23, 19:41
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: BookRelationships.java
 *  <p>
 * Project-name: HarryPotter
 *
 */

package assignment.four_reflection_annotations;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookRelationships {
    @SerializedName("chapters")
    private ChaptersData chaptersData;

    public ChaptersData getChaptersData() {
        return chaptersData;
    }
    public static class ChaptersData {
        @SerializedName("data")
        private List<Chapter> chapters;

        public List<Chapter> getChapters() {
            return chapters;
        }
    }
}
