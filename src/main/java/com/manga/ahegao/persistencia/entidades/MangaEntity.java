package com.manga.ahegao.persistencia.entidades;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
@Data
@Entity
@Table(name = "manga",    schema = "manga",catalog = "manga")
//@DynamicUpdate
public class MangaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;
     
    @Column(name = "start_date")
    private Date startDate;
     
    @Column(name = "synopsis")
    private String synopsis;
     
    @Column(name = "mean")
    private Integer mean;
     
    @Column(name = "ranking")
    private Integer ranking;
     
    @Column(name = "popularity")
    private Integer popularity;
     
    @Column(name = "num_list_users")
    private Integer numListUsers;
     
    @Column(name = "num_scoring_users")
    private Integer numScoringUsers;
     
    @Column(name = "num_volumes")
    private Integer numVolumes;
     
    @Column(name = "num_chapters")
    private Integer numChapters;
     
    @Column(name = "end_date")
    private Date endDate;
     
    @Column(name = "status_id")
    private Integer statusId;
     
    @Column(name = "media_type_id")
    private Integer mediaTypeId;
     
    @Column(name = "nsfw_id")
    private Integer nsfwId;


}
