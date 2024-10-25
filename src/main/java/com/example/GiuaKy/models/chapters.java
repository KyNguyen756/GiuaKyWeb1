package com.example.GiuaKy.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "chapters")
public class chapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chapter_id;

    @ManyToOne
    @JoinColumn(name = "manga_id", nullable = false, foreignKey = @ForeignKey(name = "fk_chapter_manga"))
    private manga manga;

    private String chapter_number;
    private String chapter_title;

    @Column(name = "Chapter_CreatedAt", updatable = false)
    private LocalDateTime Chapter_CreatedAt;
    private LocalDateTime Chapter_UpdatedAt;

    public chapters() {}

    public int getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
    }

    public com.example.GiuaKy.models.manga getManga() {
        return manga;
    }

    public void setManga(com.example.GiuaKy.models.manga manga) {
        this.manga = manga;
    }

    public String getChapter_number() {
        return chapter_number;
    }

    public void setChapter_number(String chapter_number) {
        this.chapter_number = chapter_number;
    }

    public String getChapter_title() {
        return chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

    public LocalDateTime getChapter_CreatedAt() {
        return Chapter_CreatedAt;
    }

    public void setChapter_CreatedAt(LocalDateTime chapter_CreatedAt) {
        Chapter_CreatedAt = chapter_CreatedAt;
    }

    public LocalDateTime getChapter_UpdatedAt() {
        return Chapter_UpdatedAt;
    }

    public void setChapter_UpdatedAt(LocalDateTime chapter_UpdatedAt) {
        Chapter_UpdatedAt = chapter_UpdatedAt;
    }
}
