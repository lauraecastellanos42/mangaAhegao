package com.manga.ahegao.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class MangaInputDto {

    private String title;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private Date startDate;
    private String synopsis;
    private Integer numVolum;
    private Integer numChtrs;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private Date endDate;
    private Integer statusId;
    private Integer mediaTypeId;
    private Integer nsfwId;

}
