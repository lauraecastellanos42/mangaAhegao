package com.manga.ahegao.persistencia.repositorios;

import com.manga.ahegao.persistencia.entidades.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepositorio extends JpaRepository<GenreEntity, Integer> {
}
