package com.manga.ahegao.persistencia.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "author_manga",  schema = "manga",catalog = "manga")
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


}
