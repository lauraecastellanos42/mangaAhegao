package com.manga.ahegao.dtos;

import lombok.Data;

import java.util.Date;
@Data
public class MangaDto {
    int numVolumes;
    String title;
    String titleJapanese;
    String synopsis;
    Date startDate;
    Date endDate;



}
