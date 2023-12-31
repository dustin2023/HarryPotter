/*
 * Copyright (c) 30-31.12.23, 14:07
 * Since: Dezember 2023
 *   <p>
 * Author: dustin
 *  <p>
 * Name: BookRelationships.java
 *  <p>
 * Project-name: HarryPotter
 *
 */

package assignment.four_reflection_annotations.model;

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

        @Override
        public String toString() {
            return "ChaptersData{" +
                    "chapters=" + chapters +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BookRelationships{" +
                "chaptersData=" + chaptersData +
                '}';
    }
}
