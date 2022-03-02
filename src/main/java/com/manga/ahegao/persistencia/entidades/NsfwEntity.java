package com.manga.ahegao.persistencia.entidades;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "nsfw",    schema = "manga",catalog = "manga")
public class NsfwEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
     
    @Column(name = "name")
    private String name;


}
