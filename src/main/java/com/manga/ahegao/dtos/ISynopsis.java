package com.manga.ahegao.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Date;

public interface ISynopsis {

    String getId();
    String getTitle();
    String getSynopsis();
    Double getRanking();
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    Date getStartDate();
    LocalDate getEndDate();
}
