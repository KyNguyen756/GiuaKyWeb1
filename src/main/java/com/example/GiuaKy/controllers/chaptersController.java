package com.example.GiuaKy.controllers;

import com.example.GiuaKy.models.chapters;
import com.example.GiuaKy.services.chaptersService;
import com.example.GiuaKy.services.mangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class chaptersController {
    @Autowired
    chaptersService chaptersService;

    @PostMapping("/chapters")
    @ResponseBody
    public ResponseEntity<chapters> addChapter(@RequestBody chapters chapter) {
        chaptersService.addChapter(chapter);
        return ResponseEntity.status(201).body(chapter);
    }

    @GetMapping("/chapters")
    @ResponseBody
    public List<chapters> getAllChapters() {
        return chaptersService.getAllChapters();
    }

    @GetMapping("/chapters/{chapter_id}")
    @ResponseBody
    public ResponseEntity<chapters> getMangaById(@PathVariable("chapter_id") int chapterId) {
        for (chapters chapter : chaptersService.getAllChapters()) {
            if (chapter.getChapter_id() == chapterId) {
                return ResponseEntity.status(200).body(chapter);
            }
        }
        return ResponseEntity.status(404).body(null);
    }

    @PutMapping("/chapters/{chapter_id}")
    @ResponseBody
    public ResponseEntity<chapters> updateChapter(@PathVariable("chapter_id") int chapterId, @RequestBody chapters updateChapter){
        chapters chapter = chaptersService.getChapterById(chapterId);
        if (chapter != null) {
            chapter.setChapter_number(updateChapter.getChapter_number());
            chapter.setChapter_title(updateChapter.getChapter_title());
            chaptersService.updateChapter(chapter);
            return ResponseEntity.status(200).body(chapter);
        }
        return ResponseEntity.status(404).body(null);
    }

    @DeleteMapping("/chapters/{chapter_id}")
    @ResponseBody
    public List<chapters> deleteChapter(@PathVariable("chapter_id") int chapterId) {
       chaptersService.deleteChapter(chapterId);
       return chaptersService.getAllChapters();
    }
}
