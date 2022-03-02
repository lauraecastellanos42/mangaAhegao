package com.manga.ahegao.persistencia.entidades;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
@Data
public class AuthorMangaEntityPK implements Serializable {
    @Column(name = "author_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;
    @Column(name = "manga_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mangaId;
}
