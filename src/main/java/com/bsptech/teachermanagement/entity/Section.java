/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "section")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s")
    , @NamedQuery(name = "Section.findById", query = "SELECT s FROM Section s WHERE s.id = :id")
    , @NamedQuery(name = "Section.findByName", query = "SELECT s FROM Section s WHERE s.name = :name")
    , @NamedQuery(name = "Section.findByPrice", query = "SELECT s FROM Section s WHERE s.price = :price")
    , @NamedQuery(name = "Section.findByPlaylistUrl", query = "SELECT s FROM Section s WHERE s.playlistUrl = :playlistUrl")
    , @NamedQuery(name = "Section.findByThumbnailPath", query = "SELECT s FROM Section s WHERE s.thumbnailPath = :thumbnailPath")
    , @NamedQuery(name = "Section.findByAbout", query = "SELECT s FROM Section s WHERE s.about = :about")})
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Size(max = 255)
    @Column(name = "playlist_url")
    private String playlistUrl;
    @Size(max = 255)
    @Column(name = "thumbnail_path")
    private String thumbnailPath;
    @Size(max = 500)
    @Column(name = "about")
    private String about;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;
    @OneToMany(mappedBy = "sectionId", fetch = FetchType.LAZY)
    private List<SectionFeedback> sectionFeedbackList;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sectionId", fetch = FetchType.LAZY)
    private List<LessonSection> lessonSectionList;
    @Size(max = 255)
    @Column(name = "thread_files_path")
    private String threadFilesPath;
    @OneToMany(mappedBy = "sectionId" , fetch = FetchType.LAZY)
    private List<Video> videoId;
    @OneToMany(mappedBy = "sectionId" , fetch = FetchType.LAZY)
    private List<File>fileList;

    public Section() {
    }

    public Section(Integer id) {
        this.id = id;
    }

    public Section(Integer id, String name) {
        this.id = id;
        this.name = name;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Video> getVideoId() {
        return videoId;
    }

    public void setVideoId(List<Video> videoId) {
        this.videoId = videoId;
    }

    public String getPlaylistUrl() {
        return playlistUrl;
    }

    public void setPlaylistUrl(String playlistUrl) {
        this.playlistUrl = playlistUrl;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getThreadFilesPath() {
        return threadFilesPath;
    }

    public void setThreadFilesPath(String threadFilesPath) {
        this.threadFilesPath = threadFilesPath;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    
    @XmlTransient
    public List<SectionFeedback> getSectionFeedbackList() {
        return sectionFeedbackList;
    }

    public void setSectionFeedbackList(List<SectionFeedback> sectionFeedbackList) {
        this.sectionFeedbackList = sectionFeedbackList;
    }

    @XmlTransient
    public List<LessonSection> getLessonSectionList() {
        return lessonSectionList;
    }

    public void setLessonSectionList(List<LessonSection> lessonSectionList) {
        this.lessonSectionList = lessonSectionList;
    }
     @XmlTransient
    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Section)) {
            return false;
        }
        Section other = (Section) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.teachermanagement.entity.Section[ id=" + id + " ]";
    }
    
}
