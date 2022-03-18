package com.manga.ahegao.persistencia.entidades;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "genre",    schema = "manga",catalog = "manga")
public class GenreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


}
