package com.manga.ahegao.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class MangaGenreEntityPK implements Serializable {
    @Column(name = "manga_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mangaId;
    @Column(name = "genre_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genreId;

    public Integer getMangaId() {
        return mangaId;
    }

    public void setMangaId(Integer mangaId) {
        this.mangaId = mangaId;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MangaGenreEntityPK that = (MangaGenreEntityPK) o;
        return Objects.equals(mangaId, that.mangaId) && Objects.equals(genreId, that.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mangaId, genreId);
    }
}
