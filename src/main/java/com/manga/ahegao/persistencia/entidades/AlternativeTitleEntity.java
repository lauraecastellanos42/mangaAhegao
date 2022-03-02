package com.manga.ahegao.persistencia.entidades;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode
//@ToString
@Data
@Entity
@Table(name = "alternative_title", schema = "manga",catalog = "manga")
public class AlternativeTitleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "manga_id")
    private Integer mangaId;

    @Column(name = "synonyms")
    private String synonyms;
     
    @Column(name = "english")
    private String english;
     
    @Column(name = "japanese")
    private String japanese;

}
