package com.example.GiuaKy.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "manga")
public class manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manga_id;
    private String title;
    private String description;
    private String cover_image;
    private String author;

    @Enumerated(EnumType.STRING)
    private State state = State.UNFINISHED;

    @Column(name = "CreatedAt", updatable = false)
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;

    public manga() {}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getManga_id() {
        return manga_id;
    }

    public void setManga_id(int manga_id) {
        this.manga_id = manga_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        CreatedAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        UpdatedAt = updatedAt;
    }
    public enum State {
        UNFINISHED,
        FINISHED
    }
}
