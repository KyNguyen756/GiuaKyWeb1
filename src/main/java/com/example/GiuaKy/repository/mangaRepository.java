package com.example.GiuaKy.repository;

import com.example.GiuaKy.models.manga;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface mangaRepository extends JpaRepository<manga, Integer> {

}
