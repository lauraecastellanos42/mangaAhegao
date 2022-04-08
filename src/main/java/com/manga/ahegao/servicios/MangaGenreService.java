package com.manga.ahegao.servicios;

import com.manga.ahegao.persistencia.entidades.MangaEntity;
import com.manga.ahegao.persistencia.entidades.MangaGenreEntity;
import com.manga.ahegao.persistencia.repositorios.MangaGenreRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MangaGenreService {
    @Autowired
    MangaGenreRepositorio mangaGenreRepositorio;

    public List<MangaGenreEntity> asociarMangeyGenero(MangaEntity mangaEntity,List<Integer> generos){
        List<MangaGenreEntity> mangaGenreEntities = generos.stream().map(genero -> new MangaGenreEntity(mangaEntity.getId(), genero)).collect(Collectors.toList());
        return mangaGenreRepositorio.saveAll(mangaGenreEntities);
    }
}
