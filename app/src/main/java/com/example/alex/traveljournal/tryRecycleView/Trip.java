package com.example.alex.traveljournal.tryRecycleView;

public class Trip {
    private String Name;
    private String Description;
    private String Image;

    public Trip() {
    }

    public Trip(String name, String description, String image) {
        Name = name;
        Description = description;
        Image = image;
    }
    //Getter

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getImage() {
        return Image;
    }
    //Setter

    public void setName(String name) {
        Name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImage(String image) {
        Image = image;
    }
}
