package com.manga.ahegao.persistencia.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manga_genre", schema = "manga", catalog = "")
@IdClass(MangaGenreEntityPK.class)
public class MangaGenreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "manga_id")
    private Integer mangaId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "genre_id")
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
        MangaGenreEntity that = (MangaGenreEntity) o;
        return Objects.equals(mangaId, that.mangaId) && Objects.equals(genreId, that.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mangaId, genreId);
    }
}
