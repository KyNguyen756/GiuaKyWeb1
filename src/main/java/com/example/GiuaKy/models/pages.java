package com.example.GiuaKy.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pages")
public class pages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int page_id;

    @ManyToOne
    @JoinColumn(name = "chapter_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pages_chapter"))
    private chapters chapter;

    private int page_number;
    private String image_url;

    public pages() {}

    public int getPage_id() {
        return page_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public chapters getChapter() {
        return chapter;
    }

    public void setChapter(chapters chapter) {
        this.chapter = chapter;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
