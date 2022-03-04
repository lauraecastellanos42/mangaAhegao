package com.manga.ahegao.persistencia.repositorios;

import com.manga.ahegao.persistencia.entidades.MangaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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
     */
    List<MangaEntity>findAllByStartDateGreaterThanEqualAndEndDateLessThanOrderByStartDate(Date startDate,Date endDate);

}
