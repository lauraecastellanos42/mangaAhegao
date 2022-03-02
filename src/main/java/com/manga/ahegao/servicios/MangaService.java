package com.manga.ahegao.servicios;

import com.manga.ahegao.persistencia.entidades.MangaEntity;
import com.manga.ahegao.persistencia.repositorios.MangaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MangaService {
   @Autowired
    MangaRepositorio mangaRep;

    public MangaEntity findById(){
       return mangaRep.findById(12).orElse(null);
    }
}
