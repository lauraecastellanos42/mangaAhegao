package com.manga.ahegao.persistencia.repositorios;

import com.manga.ahegao.persistencia.entidades.MangaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MangaRepositorio extends JpaRepository <MangaEntity,Integer>  {
}
