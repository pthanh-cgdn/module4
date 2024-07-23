package com.codegyme.song_colection.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.Annotation;

public class SongDto{
    private Long id;
    @NotBlank(message = "Title could not be blank")
    @Size(max=800,message = "Title is too long, could not be longer than 800 characters")
    @Pattern(regexp="^[a-zA-Z0-9\\s]*$", message = "Title could not include special character")
    private String title;
    @NotBlank(message = "Artist could not be blank")
    @Size(max=300,message = "Artist is too long, could not be longer than 300 characters")
    @Pattern(regexp="^[a-zA-Z0-9\\s]*$", message = "Artist could not include special character")
    private String artist;
    @NotBlank(message = "Music type could not be blank")
    @Size(max=1000,message = "Music type is too long, could not be longer than 1000 characters")
    @Pattern(regexp="^[a-zA-Z0-9,\\s]*$", message = "Music type could not include special character")
    private String type;

    public SongDto() {
    }

    public SongDto(String title, String artist, String type) {
        this.title = title;
        this.artist = artist;
        this.type = type;
    }

    public SongDto(Long id, String title, String artist, String type) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
