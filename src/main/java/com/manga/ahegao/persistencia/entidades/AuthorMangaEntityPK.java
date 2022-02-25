package com.manga.ahegao.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AuthorMangaEntityPK implements Serializable {
    @Column(name = "author_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Column(name = "manga_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mangaId;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getMangaId() {
        return mangaId;
    }

    public void setMangaId(Integer mangaId) {
        this.mangaId = mangaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorMangaEntityPK that = (AuthorMangaEntityPK) o;
        return Objects.equals(authorId, that.authorId) && Objects.equals(mangaId, that.mangaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, mangaId);
    }
}
