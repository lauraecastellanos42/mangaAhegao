package com.manga.ahegao.servicios;

import com.manga.ahegao.dtos.*;
import com.manga.ahegao.mapper.MangaMapper;
import com.manga.ahegao.persistencia.entidades.MangaEntity;
import com.manga.ahegao.persistencia.entidades.MangaGenreEntity;
import com.manga.ahegao.persistencia.entidades.MangaGenreEntityPK;
import com.manga.ahegao.persistencia.repositorios.GenreRepositorio;
import com.manga.ahegao.persistencia.repositorios.MangaGenreRepositorio;
import com.manga.ahegao.persistencia.repositorios.MangaRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MangaService {
    @Autowired
    MangaRepositorio mangaRep;
    @Autowired
    MangaMapper mangaMapper;
    @Autowired
    MangaGenreRepositorio mangaGenreRepositorio;
    @Autowired
    GenreRepositorio genreRepositorio;
    @Autowired
    MangaGenreService mangaGenreService;

    public MangaEntity findById() {
        return mangaRep.findById(12).orElse(null);
    }

    public List<MangaEntity> findByAuthor(int idAuthor) {
        return mangaRep.findByAuthor(idAuthor);
    }

    public List<MangaEntity> findByGenre(int idGenre) {
        return mangaRep.findByGender(idGenre);
    }

    public List<MangaEntity> findAllByMeanIsGreaterThan(int mean) {
        return mangaRep.findAllByMeanIsGreaterThan(mean);
    }

    public List<MangaEntity> getTopNumVolum() {
        return mangaRep.findTop5ByOrderByNumVolumesDesc();
    }

    public List<MangaEntity> getMangaBetweenDate(Date startDate, Date endDate) throws ParseException {
        return mangaRep.findAllByStartDateGreaterThanEqualAndEndDateLessThanOrderByStartDate(startDate, endDate);
    }

    public MangaDto findMaxVolumSinseGenre(int idGenre) {
        List<Object[]> listObject = mangaRep.findMaxVolumSinseGenre(idGenre);
        Object[] arreglo = listObject.get(0);
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

    //    public MangaEntity saveManga(MangaInputDto mangaInput){
//        MangaEntity mangaEntity = new MangaEntity();
//        mangaEntity.setTitle(mangaInput.getTitle());
//        mangaEntity.setStartDate(mangaInput.getStartDate());
//        mangaEntity.setSynopsis(mangaInput.getSynopsis());
//        mangaEntity.setNumVolumes(mangaInput.getNumVolumes());
//        mangaEntity.setNumChapters(mangaInput.getNumChapters());
//        mangaEntity.setEndDate(mangaInput.getEndDate());
//        mangaEntity.setStatusId(mangaInput.getStatusId());
//        mangaEntity.setMediaTypeId(mangaInput.getMediaTypeId());
//        mangaEntity.setNsfwId(mangaInput.getNsfwId());
//        mangaRep.save(mangaEntity);
//        return mangaEntity;
//    }

    @Transactional(rollbackFor = Exception.class, noRollbackFor = {RuntimeException.class, JpaSystemException.class})
    public MangaEntity saveManga(MangaInputDto mangaInput) {
        MangaEntity mangaEntity= mangaMapper.toEntity(mangaInput);
        mangaRep.save(mangaEntity);
        mangaGenreService.asociarMangeyGenero(mangaEntity,mangaInput.getGeneros());
        return mangaEntity;
    }

    @Transactional
    public MangaEntity finalizeManga(int id){
        MangaEntity mangaEntity = mangaRep.findById(id).get();
        mangaRep.updateState(id);
        mangaEntity = mangaRep.findById(id).get();
        return mangaEntity;
    }

    @Transactional
    public List<MangaEntity> recuperarMangaHoy(int id){
        MangaEntity mangaEntity = mangaRep.findById(id).get();
        mangaEntity.setEndDate(new Date());
        mangaRep.save(mangaEntity);
        System.out.println(mangaRep.UpdateHoy());
        return mangaRep.mangaAcabaHoy();
    }
}
