package com.manga.ahegao.controlador;

import com.manga.ahegao.persistencia.entidades.MangaEntity;
import com.manga.ahegao.servicios.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manga")
public class MangaController {
    @Autowired
    MangaService mangaService;

    @GetMapping("findbyid")
    public MangaEntity findById(){
        return mangaService.findById();
    }
}
