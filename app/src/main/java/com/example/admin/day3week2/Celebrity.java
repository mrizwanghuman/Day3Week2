package com.example.admin.day3week2;

/**
 * Created by  Admin on 11/16/2017.
 */

public class Celebrity {
    String Name;
    String Description;
    int imageId;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Celebrity(String name, String description, int imageId) {
        Name = name;
        Description = description;
        this.imageId = imageId;
    }
}
