package com.manga.ahegao.persistencia.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "manga_genre",    schema = "manga",catalog = "manga")
@IdClass(MangaGenreEntityPK.class)
@NoArgsConstructor
@AllArgsConstructor
public class MangaGenreEntity  implements Persistable<MangaGenreEntityPK> {
    @Id
    @Column(name = "manga_id")
    private Integer mangaId;
    @Id
    @Column(name = "genre_id")
    private Integer genreId;

    @Transient
    private boolean isNew = true;

    public MangaGenreEntity(Integer mangaId, Integer genreId) {
        this.mangaId = mangaId;
        this.genreId = genreId;
    }

    @Override
    public MangaGenreEntityPK getId() {
        return new MangaGenreEntityPK(this.mangaId,this.genreId);
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    @PostLoad//Despues de leer de BD
    @PrePersist//antes de persistir
    void setNotNew() {
        this.isNew = false;
    }


}
