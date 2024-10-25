package com.example.GiuaKy.services;

import com.example.GiuaKy.models.chapters;
import com.example.GiuaKy.models.manga;
import com.example.GiuaKy.repository.mangaRepository;
import com.example.GiuaKy.repository.chaptersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class chaptersService {
    @Autowired
    chaptersRepository chaptersRepository;

    public List<chapters> getAllChapters(){
        return chaptersRepository.findAll();
    }

    public chapters getChapterById(int id){
        return chaptersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chapter not found with id: " + id));
    }

    public chapters addChapter(chapters chapter){
        return chaptersRepository.save(chapter);
    }

    public chapters updateChapter(chapters chapter){
        return chaptersRepository.save(chapter);
    }

    public void deleteChapter(int id){
        chaptersRepository.deleteById(id);
    }

}
