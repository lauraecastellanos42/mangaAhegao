package com.manga.ahegao.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface IMangaMean {

    Integer getId();
    String getTitle();
    @Value("#{target.mean/100.0}")
    Double getMean();
}
