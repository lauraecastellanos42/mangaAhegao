package com.manga.ahegao.persistencia.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "picture",    schema = "manga",catalog = "manga")
public class PictureEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "manga_id")
    private Integer mangaId;

    @Column(name = "medium")
    private String medium;
     
    @Column(name = "large")
    private String large;
}
