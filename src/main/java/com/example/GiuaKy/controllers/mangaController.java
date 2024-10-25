package com.example.GiuaKy.controllers;

import com.example.GiuaKy.models.manga;
import com.example.GiuaKy.services.mangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class mangaController {
    @Autowired
    mangaService mangaService;

    public mangaController() {}

    @PostMapping("/manga")
    @ResponseBody
    public ResponseEntity<manga> addManga(@RequestBody manga manga) {
        mangaService.addManga(manga);
        return ResponseEntity.status(201).body(manga);
    }

    @GetMapping("/manga")
    @ResponseBody
    public List<manga> getAllManga() {
        return mangaService.getAllManga();
    }

    @GetMapping("/manga/{manga_id}")
    @ResponseBody
    public ResponseEntity<manga> getMangaById(@PathVariable("manga_id") int mangaId) {
        for (manga manga : mangaService.getAllManga()) {
            if (manga.getManga_id() == mangaId) {
                return ResponseEntity.status(200).body(manga);
            }
        }
        return ResponseEntity.status(404).body(null);
    }

    @PutMapping("/manga/{manga_id}")
    @ResponseBody
    public ResponseEntity<manga> updateManga(@PathVariable("manga_id") int mangaId, @RequestBody manga updateManga){
        manga manga = mangaService.findMangabyid(mangaId);
        if (manga != null) {
            manga.setTitle(updateManga.getTitle());
            manga.setDescription(updateManga.getDescription());
            manga.setAuthor(updateManga.getAuthor());
            manga.setCover_image(updateManga.getCover_image());
            mangaService.updateManga(manga);
            return ResponseEntity.status(200).body(manga);
        }
        return ResponseEntity.status(404).body(null);
    }

    @DeleteMapping("/manga/{manga_id}")
    @ResponseBody
    public List<manga> deleteManga(@PathVariable("manga_id") int mangaId) {
        mangaService.deleteManga(mangaId);
        return mangaService.getAllManga();
    }
}
