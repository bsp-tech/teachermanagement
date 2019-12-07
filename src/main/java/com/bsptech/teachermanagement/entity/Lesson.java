/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "lesson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l")
    , @NamedQuery(name = "Lesson.findById", query = "SELECT l FROM Lesson l WHERE l.id = :id")
    , @NamedQuery(name = "Lesson.findByName", query = "SELECT l FROM Lesson l WHERE l.name = :name")
    , @NamedQuery(name = "Lesson.findByAbout", query = "SELECT l FROM Lesson l WHERE l.about = :about")
    , @NamedQuery(name = "Lesson.findByThumbnailPath", query = "SELECT l FROM Lesson l WHERE l.thumbnailPath = :thumbnailPath")
    , @NamedQuery(name = "Lesson.findByInsertDateTime", query = "SELECT l FROM Lesson l WHERE l.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "Lesson.findByLastUpdateTime", query = "SELECT l FROM Lesson l WHERE l.lastUpdateTime = :lastUpdateTime")})
public class Lesson implements Serializable {

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
    @Size(max = 255)
    @Column(name = "about")
    private String about;
    @Size(max = 255)
    @Column(name = "thumbnail_path")
    private String thumbnailPath;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "lessonId", fetch = FetchType.LAZY)
    private List<LessonSection> lessonSectionList;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "lessonId", fetch = FetchType.LAZY)
    private List<ClassLesson> classLessonList;

    public Lesson() {
    }

    public Lesson(Integer id) {
        this.id = id;
    }

    public Lesson(Integer id, String name, Date insertDateTime) {
        this.id = id;
        this.name = name;
        this.insertDateTime = insertDateTime;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
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
    public List<LessonSection> getLessonSectionList() {
        return lessonSectionList;
    }

    public void setLessonSectionList(List<LessonSection> lessonSectionList) {
        this.lessonSectionList = lessonSectionList;
    }

    @XmlTransient
    public List<ClassLesson> getClassLessonList() {
        return classLessonList;
    }

    public void setClassLessonList(List<ClassLesson> classLessonList) {
        this.classLessonList = classLessonList;
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
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.teachermanagement.entity.Lesson[ id=" + id + " ]";
    }
    
}
