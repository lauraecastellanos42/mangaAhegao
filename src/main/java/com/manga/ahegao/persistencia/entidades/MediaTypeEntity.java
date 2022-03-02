package com.manga.ahegao.persistencia.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "media_type",    schema = "manga",catalog = "manga")
public class MediaTypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
     
    @Column(name = "name")
    private String name;


}
