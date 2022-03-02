package com.manga.ahegao.persistencia.entidades;

import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.OPCode;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
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
