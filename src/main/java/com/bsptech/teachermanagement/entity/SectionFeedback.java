/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "section_feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectionFeedback.findAll", query = "SELECT s FROM SectionFeedback s")
    , @NamedQuery(name = "SectionFeedback.findById", query = "SELECT s FROM SectionFeedback s WHERE s.id = :id")
    , @NamedQuery(name = "SectionFeedback.findByContent", query = "SELECT s FROM SectionFeedback s WHERE s.content = :content")
    , @NamedQuery(name = "SectionFeedback.findByInsertDateTime", query = "SELECT s FROM SectionFeedback s WHERE s.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "SectionFeedback.findByAuthorName", query = "SELECT s FROM SectionFeedback s WHERE s.authorName = :authorName")})
public class SectionFeedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Size(max = 255)
    @Column(name = "author_name")
    private String authorName;
    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Section sectionId;

    public SectionFeedback() {
    }

    public SectionFeedback(Integer id) {
        this.id = id;
    }

    public SectionFeedback(Integer id, Date insertDateTime) {
        this.id = id;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Section getSectionId() {
        return sectionId;
    }

    public void setSectionId(Section sectionId) {
        this.sectionId = sectionId;
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
        if (!(object instanceof SectionFeedback)) {
            return false;
        }
        SectionFeedback other = (SectionFeedback) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.teachermanagement.entity.SectionFeedback[ id=" + id + " ]";
    }
    
}
