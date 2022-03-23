package com.manga.ahegao.persistencia.repositorios;

import com.manga.ahegao.dtos.IManga;
import com.manga.ahegao.dtos.IMangaMean;
import com.manga.ahegao.dtos.ISynopsis;
import com.manga.ahegao.dtos.MangaInfoDto;
import com.manga.ahegao.persistencia.entidades.MangaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface MangaRepositorio extends JpaRepository <MangaEntity,Integer>  {


    /**
     * Find all the manga written by an author
     * Esto se realiza usando query nativo
     * @param idAuthor The id of the author.
     * @return A list of MangaEntity objects.
     */
    @Query(value = "select manga.*\n" +
            "from manga\n" +
            "inner join author_manga on author_manga.manga_id = manga.id\n" +
            "inner join author on author.id = author_manga.author_id\n" +
            "where author.id = ?",nativeQuery = true)
    public List<MangaEntity> findByAuthor(int idAuthor);

    /**
     * This function returns the manga with the most number of volumes in a given genre
     *
     * @param idGenre The id of the genre we want to find the manga with the most volumes.
     * @return The manga with the most volumes.
     */
    @Query(value = "select max(manga.num_volumes) as numVolumenes,  manga.title as nombre,\n" +
            "nA.japanese ,manga.synopsis, manga.start_date, manga.end_date\n" +
            "from manga \n" +
            "inner join manga_genre on manga_genre.manga_id = manga.id \n" +
            "inner join genre on genre.id = manga_genre.genre_id\n" +
            "left join alternative_title nA on nA.manga_id = manga.id\n" +
            "where genre.id = ? \n" +
            "group by genre.id",nativeQuery = true)
        public List<Object[]> findMaxVolumSinseGenre(int idGenre);

    /* guia para escribir el jpaql:
    * select manga.*
        from manga
        inner join manga_genre on manga_genre.manga_id = manga.id
        inner join genre on genre.id = manga_genre.genre_id
        where genre.id = 5;
    * */
    /**
     * Find all the manga that have a genre with the given id
     * Este query se realiza utilizando JPAQL
     * @param idGender The id of the genre we want to find.
     * @return A list of MangaEntity objects.
     */
    @Query(value = "SELECT M  FROM MangaEntity M " +
            "INNER JOIN MangaGenreEntity MG ON MG.mangaId = M.id " +
            "INNER JOIN GenreEntity G ON G.id = MG.genreId " +
            "WHERE G.id = ?1")
    public List<MangaEntity> findByGender(int idGender);

    /*
    * select * from manga m where m.mean > 900;
    *methodquery
     */
    /**
     * Find all the mangas with a mean greater than the given mean
     * Este es un methodQuery -> el query se genera a partir del nombre del metodo
     * es agnostico a la base de datos -> se genera acorde al motor BD
     * @param mean the mean of the manga you want to find
     * @return A list of all the mangas with a mean greater than the given mean.
     */
    List<MangaEntity>findAllByMeanIsGreaterThan(int mean);

    /**
     * Obtiene los 5 mangas con mayor cantidad de volumenes
     * Este es un methodQuery -> el query se genera a partir del nombre del metodo
     * @return A list of the top 5 manga by the number of volumes.
     */
    List<MangaEntity>findTop5ByOrderByNumVolumesDesc();

    /*
    * select m.title,m.start_date,m.end_date from manga m where m.start_date >= date("1993-01-01") AND m.end_date < current_date() order by m.start_date ;
    * */
    /**
     * Find all the manga that have a start date less than or equal to the given start date and an end date greater than
     * the given end date
     *
     * @param startDate The start date of the manga
     * @param endDate The date that the manga ended on.
     * @return A List of MangaEntity objects
     *
     */
    List<MangaEntity>findAllByStartDateGreaterThanEqualAndEndDateLessThanOrderByStartDate(Date startDate,Date endDate);

    /**
     * Proyección escalar nativo
     */
    @Query(value = "SELECT id, title, synopsis\n" +
            "FROM manga.manga\n" +
            "WHERE synopsis like %:synopsis%", nativeQuery = true)
    List<Map<String, Object>> findBySynopsisNative(@Param("synopsis") String synopsis);

    /**
     * Proyección escalar JPAQL
     */
    @Query("SELECT m.id as id, m.title as title, m.synopsis as synopsis FROM MangaEntity m WHERE m.synopsis like %:synopsis%")
    List<Map<String, Object>> findBySynopsisJpaql(@Param("synopsis") String synopsis);

    /**
     * Proyección cerrada nativo
     * @param synopsis
     * @return
     */
    @Query(value = "SELECT id, title, synopsis, start_date as startDate, end_date as endDate\n" +
            "FROM manga.manga\n" +
            "WHERE synopsis like %:synopsis%", nativeQuery = true)
    List<ISynopsis> findBySynopsisINative(@Param("synopsis") String synopsis);

    /**
     * Proyección cerrada JPAQL
     * @param synopsis
     * @return
     */
    @Query("SELECT m.id as id, m.title as title, m.synopsis as synopsis, m.ranking as ranking, m.startDate as startDate, m.endDate as endDate " +
            "FROM MangaEntity m WHERE m.synopsis like %:synopsis%")
    List<ISynopsis> findBySynopsisIJpaql(@Param("synopsis") String synopsis);

    /**
     * Interfaces compuestas
     * @param synopsis
     * @return
     */
    //TODO Revisar por qué no funciona
    @Query("SELECT m.title as title, at.japanese as japanese " +
            "FROM MangaEntity m " +
            "LEFT JOIN AlternativeTitleEntity at ON m.id = at.mangaId " +
            "WHERE m.synopsis like %:synopsis%")
    List<IManga> findCompBySynopsis(@Param("synopsis") String synopsis);

    /**
     * Proyecciones abiertas con method query
     * @param chapters
     * @return
     */
    //@Query(value = "SELECT m FROM MangaEntity m WHERE m.numChapters > :chapters")
    List<IMangaMean> findAllByNumChaptersGreaterThan(int chapters);

    /**
     * Proyecciones basadas en clases
     * @param genreId
     * @return
     */
    @Query("SELECT new com.manga.ahegao.dtos.MangaInfoDto(m.id, m.title, p.large) " +
           "FROM MangaEntity m " +
           "LEFT JOIN PictureEntity p ON m.id = p.mangaId " +
           "JOIN MangaGenreEntity mg ON m.id = mg.mangaId " +
           "WHERE mg.genreId = :genreId " +
           "AND m.statusId = 1")
    List<MangaInfoDto> findByGenre(Integer genreId);

    /**
     * Proyecciones basadas en clases
     * @param genreId
     * @return
     */
    @Query("SELECT new com.manga.ahegao.dtos.MangaInfoDto(m.id, m.title, p.large) " +
            "FROM MangaEntity m " +
            "LEFT JOIN PictureEntity p ON m.id = p.mangaId " +
            "JOIN MangaGenreEntity mg ON m.id = mg.mangaId " +
            "WHERE mg.genreId = :genreId " +
            "AND m.statusId = 1")
    List<MangaInfoDto> findByGenreUri(Integer genreId);
}
