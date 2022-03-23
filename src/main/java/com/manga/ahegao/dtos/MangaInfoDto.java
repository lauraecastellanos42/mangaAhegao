package com.manga.ahegao.dtos;

import lombok.Data;

import java.net.URI;
import java.net.URISyntaxException;

@Data
public class MangaInfoDto {

    private Integer id;
    private String title;
    private String large;
    private URI largeUrl;

    public MangaInfoDto(Integer id, String title, String large) throws URISyntaxException {
        this.id = id;
        this.title = title;
        this.large = large;
        this.largeUrl = new URI(this.large);
    }
}
