package com.example.GiuaKy.services;

import com.example.GiuaKy.models.manga;
import com.example.GiuaKy.repository.mangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class mangaService {

    @Autowired
    private mangaRepository mangaRepository;

    public manga addManga(manga manga) {
        return mangaRepository.save(manga);
    }

    public List<manga> getAllManga() {
        return mangaRepository.findAll();
    }

    public manga findMangabyid(int id) {
        return mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found"));
    }

    public manga updateManga(manga manga) {
        return mangaRepository.save(manga);
    }

    public void deleteManga(int id) {
        if (!mangaRepository.existsById(id)) {
            throw new RuntimeException("Manga not found");
        }
        mangaRepository.deleteById(id);
    }
}
