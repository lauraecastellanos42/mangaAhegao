package com.manga.ahegao.persistencia.repositorios;

import com.manga.ahegao.persistencia.entidades.MangaGenreEntity;
import com.manga.ahegao.persistencia.entidades.MangaGenreEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaGenreRepositorio extends JpaRepository<MangaGenreEntity, MangaGenreEntityPK> {
}
