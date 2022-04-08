package com.manga.ahegao.persistencia.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaGenreEntityPK implements Serializable {
    private Integer mangaId;
    private Integer genreId;
}
