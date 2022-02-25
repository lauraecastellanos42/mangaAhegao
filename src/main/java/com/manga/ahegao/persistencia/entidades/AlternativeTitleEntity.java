package com.manga.ahegao.persistencia.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "alternative_title", schema = "manga", catalog = "")
public class AlternativeTitleEntity {
    @Basic
    @Column(name = "synonyms")
    private String synonyms;
    @Basic
    @Column(name = "english")
    private String english;
    @Basic
    @Column(name = "japanese")
    private String japanese;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "manga_id")
    private Integer mangaId;

    public String getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(String synonyms) {
        this.synonyms = synonyms;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
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
        AlternativeTitleEntity that = (AlternativeTitleEntity) o;
        return Objects.equals(synonyms, that.synonyms) && Objects.equals(english, that.english) && Objects.equals(japanese, that.japanese) && Objects.equals(mangaId, that.mangaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(synonyms, english, japanese, mangaId);
    }
}
