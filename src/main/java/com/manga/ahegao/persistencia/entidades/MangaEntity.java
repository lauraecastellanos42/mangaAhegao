package com.manga.ahegao.persistencia.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "manga", schema = "manga", catalog = "")
public class MangaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "synopsis")
    private String synopsis;
    @Basic
    @Column(name = "mean")
    private Integer mean;
    @Basic
    @Column(name = "ranking")
    private Integer ranking;
    @Basic
    @Column(name = "popularity")
    private Integer popularity;
    @Basic
    @Column(name = "num_list_users")
    private Integer numListUsers;
    @Basic
    @Column(name = "num_scoring_users")
    private Integer numScoringUsers;
    @Basic
    @Column(name = "num_volumes")
    private Integer numVolumes;
    @Basic
    @Column(name = "num_chapters")
    private Integer numChapters;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "status_id")
    private Integer statusId;
    @Basic
    @Column(name = "media_type_id")
    private Integer mediaTypeId;
    @Basic
    @Column(name = "nsfw_id")
    private Integer nsfwId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getMean() {
        return mean;
    }

    public void setMean(Integer mean) {
        this.mean = mean;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Integer getNumListUsers() {
        return numListUsers;
    }

    public void setNumListUsers(Integer numListUsers) {
        this.numListUsers = numListUsers;
    }

    public Integer getNumScoringUsers() {
        return numScoringUsers;
    }

    public void setNumScoringUsers(Integer numScoringUsers) {
        this.numScoringUsers = numScoringUsers;
    }

    public Integer getNumVolumes() {
        return numVolumes;
    }

    public void setNumVolumes(Integer numVolumes) {
        this.numVolumes = numVolumes;
    }

    public Integer getNumChapters() {
        return numChapters;
    }

    public void setNumChapters(Integer numChapters) {
        this.numChapters = numChapters;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(Integer mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public Integer getNsfwId() {
        return nsfwId;
    }

    public void setNsfwId(Integer nsfwId) {
        this.nsfwId = nsfwId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MangaEntity that = (MangaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(startDate, that.startDate) && Objects.equals(synopsis, that.synopsis) && Objects.equals(mean, that.mean) && Objects.equals(ranking, that.ranking) && Objects.equals(popularity, that.popularity) && Objects.equals(numListUsers, that.numListUsers) && Objects.equals(numScoringUsers, that.numScoringUsers) && Objects.equals(numVolumes, that.numVolumes) && Objects.equals(numChapters, that.numChapters) && Objects.equals(endDate, that.endDate) && Objects.equals(statusId, that.statusId) && Objects.equals(mediaTypeId, that.mediaTypeId) && Objects.equals(nsfwId, that.nsfwId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, startDate, synopsis, mean, ranking, popularity, numListUsers, numScoringUsers, numVolumes, numChapters, endDate, statusId, mediaTypeId, nsfwId);
    }
}
