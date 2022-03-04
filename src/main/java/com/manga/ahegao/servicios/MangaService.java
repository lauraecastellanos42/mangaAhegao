package com.manga.ahegao.servicios;

import com.manga.ahegao.persistencia.entidades.MangaEntity;
import com.manga.ahegao.persistencia.repositorios.MangaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public List<MangaEntity>getMangaBetweenDate(String startDate,String endDate) throws ParseException {
        Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        return mangaRep.findAllByStartDateGreaterThanEqualAndEndDateLessThanOrderByStartDate(date1,date2);
    }
}
