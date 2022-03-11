package com.manga.ahegao.controlador;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manga.ahegao.dtos.MangaDto;
import com.manga.ahegao.persistencia.entidades.MangaEntity;
import com.manga.ahegao.servicios.MangaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("manga")
public class MangaController {
    @Autowired
    MangaService mangaService;

    @GetMapping("findbyid")
    public MangaEntity findById(){
        return mangaService.findById();
    }

    @GetMapping("findByAuthor")
    public List<MangaEntity> findByAuthor(@RequestParam int idAuthor){
        return mangaService.findByAuthor(idAuthor);
    }

    @GetMapping("findByGenre/{idGenre}")
    public List<MangaEntity>findByGenre(@PathVariable int idGenre){
        return mangaService.findByGenre(idGenre);
    }

    @GetMapping("meanIsGreater/{mean}")
    public List<MangaEntity>findAllByMeanIsGreaterThan(@PathVariable int mean){
        return mangaService.findAllByMeanIsGreaterThan(mean);
    }
    @GetMapping("getTopNumVolum")
    public List<MangaEntity>getTopNumVolum(){
        return mangaService.getTopNumVolum();
    }
    @GetMapping("betweenDate/{startDate}/{endDate}")
    public List<MangaEntity>getMangaBetweenDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable Date endDate) throws ParseException {
        return  mangaService.getMangaBetweenDate(startDate,endDate);
    }
    @GetMapping("findMaxVolumSinseGenre/{idGenre}")
    public MangaDto findMaxVolumSinseGenre(@PathVariable int idGenre){return mangaService.findMaxVolumSinseGenre(idGenre);}
}
