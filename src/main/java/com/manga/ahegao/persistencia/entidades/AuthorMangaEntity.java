package com.manga.ahegao.persistencia.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "author_manga", schema = "manga", catalog = "")
@IdClass(AuthorMangaEntityPK.class)
public class AuthorMangaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "author_id")
    private Integer authorId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "manga_id")
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
        AuthorMangaEntity that = (AuthorMangaEntity) o;
        return Objects.equals(authorId, that.authorId) && Objects.equals(mangaId, that.mangaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, mangaId);
    }
}
