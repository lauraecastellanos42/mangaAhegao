package com.manga.ahegao.persistencia.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "picture", schema = "manga", catalog = "")
public class PictureEntity {
    @Basic
    @Column(name = "medium")
    private String medium;
    @Basic
    @Column(name = "large")
    private String large;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "manga_id")
    private Integer mangaId;

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
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
        PictureEntity that = (PictureEntity) o;
        return Objects.equals(medium, that.medium) && Objects.equals(large, that.large) && Objects.equals(mangaId, that.mangaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medium, large, mangaId);
    }
}
