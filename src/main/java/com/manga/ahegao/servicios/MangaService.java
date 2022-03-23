package com.manga.ahegao.servicios;

import com.manga.ahegao.dtos.*;
import com.manga.ahegao.persistencia.entidades.MangaEntity;
import com.manga.ahegao.persistencia.repositorios.MangaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MangaService {
   @Autowired
    MangaRepositorio mangaRep;

    public MangaEntity findById(){
       return mangaRep.findById(12).orElse(null);
    }

    public List<MangaEntity> findByAuthor(int idAuthor){
        return  mangaRep.findByAuthor(idAuthor);
    }

    public List<MangaEntity> findByGenre (int idGenre){
        return  mangaRep.findByGender(idGenre);
    }

    public List<MangaEntity>findAllByMeanIsGreaterThan(int mean){
        return  mangaRep.findAllByMeanIsGreaterThan(mean);
    }
    public List<MangaEntity>getTopNumVolum(){
        return mangaRep.findTop5ByOrderByNumVolumesDesc();
    }
    public List<MangaEntity>getMangaBetweenDate(Date startDate,Date endDate) throws ParseException {
        return mangaRep.findAllByStartDateGreaterThanEqualAndEndDateLessThanOrderByStartDate(startDate,endDate);
    }

    public MangaDto findMaxVolumSinseGenre(int idGenre){
        List<Object[]>listObject = mangaRep.findMaxVolumSinseGenre(idGenre);
        Object[] arreglo= listObject.get(0);
        MangaDto mangaDto = new MangaDto();
        mangaDto.setNumVolumes((Integer) arreglo[0]);
        mangaDto.setTitle(arreglo[1].toString());
        mangaDto.setTitleJapanese(arreglo[2].toString());
        mangaDto.setSynopsis(arreglo[3].toString());
        mangaDto.setStartDate((Date) arreglo[4]);
        mangaDto.setEndDate((Date) arreglo[5]);
        return mangaDto;
    }

    public List<Map<String, Object>> findBySynopsisNative(String synopsis) {
        return mangaRep.findBySynopsisNative(synopsis);
    }

    public List<Map<String, Object>> findBySynopsisJpaql(String synopsis) {
        return mangaRep.findBySynopsisJpaql(synopsis);
    }

    public List<ISynopsis> findBySynopsisINative(String synopsis) {
        return mangaRep.findBySynopsisINative(synopsis);
    }

    public List<ISynopsis> findBySynopsisIJpaql(String synopsis) {
        return mangaRep.findBySynopsisIJpaql(synopsis);
    }

    public List<IManga> findCompBySynopsis(String synopsis) {
        return mangaRep.findCompBySynopsis(synopsis);
    }

    public List<IMangaMean> findByChapters(int chapters) {
        return mangaRep.findAllByNumChaptersGreaterThan(chapters);
    }

    public List<MangaInfoDto> findByGenre(Integer genreId) {
        return mangaRep.findByGenre(genreId);
    }

    public List<MangaInfoDto> findByGenreUri(Integer genreId) {
        return mangaRep.findByGenreUri(genreId);
    }
}
