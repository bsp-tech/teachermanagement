package com.bsptech.teachermanagement.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@XmlRootElement
@Table(name = "file")
@NamedQueries({
        @NamedQuery(name = "File.findAll", query = "SELECT f FROM File f")
        , @NamedQuery(name = "File.findById", query = "SELECT f FROM File f WHERE f.id = :id")
        , @NamedQuery(name = "File.findByName", query = "SELECT f FROM File f WHERE f.name = :name")
        , @NamedQuery(name = "File.findByUrl", query = "SELECT f FROM File f WHERE f.url = :url")
        , @NamedQuery(name = "File.findByInsertDateTime", query = "SELECT f FROM File f WHERE f.insertDateTime = :insertDateTime")
        , @NamedQuery(name = "File.findByLastUpdateTime", query = "SELECT f FROM File f WHERE f.lastUpdateTime = :lastUpdateTime")})

public class File implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "url")
    private String url;
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Section sectionId;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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


    public Section getSectionId() {
        return sectionId;
    }

    public void setSectionId(Section sectionId) {
        this.sectionId = sectionId;
    }

    public File(@NotNull @Size(min = 1, max = 255) String name, @Size(max = 255) String url, Date insertDateTime, Date lastUpdateTime, Section sectionId) {
        this.name = name;
        this.url = url;
        this.insertDateTime = insertDateTime;
        this.lastUpdateTime = lastUpdateTime;
        this.sectionId = sectionId;
    }

    public File() {

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
        File other = (File) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "com.bsptech.teachermanagement.entity.File[ id=" + id + " ]";
    }
}
