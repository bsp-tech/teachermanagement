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
import javax.persistence.Id;
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
@Table(name = "website_settings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WebsiteSettings.findAll", query = "SELECT w FROM WebsiteSettings w")
    , @NamedQuery(name = "WebsiteSettings.findById", query = "SELECT w FROM WebsiteSettings w WHERE w.id = :id")
    , @NamedQuery(name = "WebsiteSettings.findByBannerPath", query = "SELECT w FROM WebsiteSettings w WHERE w.bannerPath = :bannerPath")
    , @NamedQuery(name = "WebsiteSettings.findByDescription", query = "SELECT w FROM WebsiteSettings w WHERE w.description = :description")
    , @NamedQuery(name = "WebsiteSettings.findByEmail", query = "SELECT w FROM WebsiteSettings w WHERE w.email = :email")
    , @NamedQuery(name = "WebsiteSettings.findByPhone", query = "SELECT w FROM WebsiteSettings w WHERE w.phone = :phone")
    , @NamedQuery(name = "WebsiteSettings.findByAutobiography", query = "SELECT w FROM WebsiteSettings w WHERE w.autobiography = :autobiography")
    , @NamedQuery(name = "WebsiteSettings.findByIntroduceVideoUrl", query = "SELECT w FROM WebsiteSettings w WHERE w.introduceVideoUrl = :introduceVideoUrl")
    , @NamedQuery(name = "WebsiteSettings.findByInsertDateTime", query = "SELECT w FROM WebsiteSettings w WHERE w.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "WebsiteSettings.findByLastUpdateDateTime", query = "SELECT w FROM WebsiteSettings w WHERE w.lastUpdateDateTime = :lastUpdateDateTime")})
public class WebsiteSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "banner_path")
    private String bannerPath;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "autobiography")
    private String autobiography;
    @Size(max = 255)
    @Column(name = "introduce_video_url")
    private String introduceVideoUrl;
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "author_name")
    private String author_name;

    public WebsiteSettings() {
    }

    public WebsiteSettings(Integer id) {
        this.id = id;
    }

    public WebsiteSettings(Integer id, String description, String email, String phone, String autobiography) {
        this.id = id;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.autobiography = autobiography;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBannerPath() {
        return bannerPath;
    }

    public void setBannerPath(String bannerPath) {
        this.bannerPath = bannerPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAutobiography() {
        return autobiography;
    }

    public void setAutobiography(String autobiography) {
        this.autobiography = autobiography;
    }

    public String getIntroduceVideoUrl() {
        return introduceVideoUrl;
    }

    public void setIntroduceVideoUrl(String introduceVideoUrl) {
        this.introduceVideoUrl = introduceVideoUrl;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
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
        if (!(object instanceof WebsiteSettings)) {
            return false;
        }
        WebsiteSettings other = (WebsiteSettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.teachermanagement.entity.WebsiteSettings[ id=" + id + " ]";
    }
    
}
