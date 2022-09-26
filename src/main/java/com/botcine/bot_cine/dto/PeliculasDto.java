package com.botcine.bot_cine.dto;

public class PeliculasDto {
    private Integer peliculasId;
    private String name;
    private String image;
    private String language;
    private String adaptation;
    private String gender;
    private String duration;
    private String definition;


    public PeliculasDto(Integer peliculasId, String name, String image, String language, String adaptation, String gender, String duration, String definition) {
        this.peliculasId = peliculasId;
        this.name = name;
        this.image = image;
        this.language = language;
        this.adaptation = adaptation;
        this.gender = gender;
        this.duration = duration;
        this.definition = definition;
    }



    public Integer getPeliculasId() {
        return peliculasId;
    }

    public void setPeliculasId(Integer peliculasId) {
        this.peliculasId = peliculasId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAdaptation() {
        return adaptation;
    }

    public void setAdaptation(String adaptation) {
        this.adaptation = adaptation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "PeliculasDto{" +
                "peliculasId=" + peliculasId +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", language='" + language + '\'' +
                ", adaptation='" + adaptation + '\'' +
                ", gender='" + gender + '\'' +
                ", duration='" + duration + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
