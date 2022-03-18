package com.manga.ahegao.controlador;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manga.ahegao.dtos.IManga;
import com.manga.ahegao.dtos.IMangaMean;
import com.manga.ahegao.dtos.ISynopsis;
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
import java.util.Map;

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

    @GetMapping("findBySynopsisNative/{synopsis}")
    public List<Map<String, Object>> findBySynopsisNative(@PathVariable String synopsis) {
        return mangaService.findBySynopsisNative(synopsis);
    }

    @GetMapping("findBySynopsisJpaql/{synopsis}")
    public List<Map<String, Object>> findBySynopsisJpaql(@PathVariable String synopsis) {
        return mangaService.findBySynopsisJpaql(synopsis);
    }

    @GetMapping("findBySynopsisINative/{synopsis}")
    public List<ISynopsis> findBySynopsisINative(@PathVariable String synopsis) {
        return mangaService.findBySynopsisINative(synopsis);
    }

    @GetMapping("findBySynopsisIJpaql/{synopsis}")
    public List<ISynopsis> findBySynopsisIJpaql(@PathVariable String synopsis) {
        return mangaService.findBySynopsisIJpaql(synopsis);
    }

    @GetMapping("findCompBySynopsis/{synopsis}")
    public List<IManga> findCompBySynopsis(@PathVariable String synopsis) {
        return mangaService.findCompBySynopsis(synopsis);
    }

    @GetMapping("findByChapters/{chapters}")
    public List<IMangaMean> findByChapters(@PathVariable int chapters) {
        return mangaService.findByChapters(chapters);
    }
}
