package com.manga.ahegao.mapper;

import com.manga.ahegao.dtos.MangaInputDto;
import com.manga.ahegao.persistencia.entidades.MangaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface MangaMapper {
    @Mappings({@Mapping(target = "numVolumes",source = "mangaInput.numVolum"),@Mapping(target = "numChapters",source = "mangaInput.numChtrs")})
    MangaEntity toEntity(MangaInputDto mangaInput);
    @Mappings({@Mapping(target = "numVolum",source = "mangaEntity.numVolumes"),@Mapping(target = "numChtrs",source = "mangaEntity.numChapters")})
    MangaInputDto toDto(MangaEntity mangaEntity);

    List<MangaEntity> toEntityList(List<MangaInputDto> mangaInputs);
    List<MangaInputDto> toDtoList(List<MangaEntity> mangaEntities);
}
