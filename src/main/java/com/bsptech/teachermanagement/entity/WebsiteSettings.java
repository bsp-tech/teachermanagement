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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "banner_path")
    private String bannerPath;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
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
    @Size(min = 1, max = 2000)
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
    @Size(max = 255)
    @Column(name = "about_img_path")
    private String aboutImgPath;
    @Size(max = 255)
    @Column(name = "contact_img_path")
    private String contactImgPath;
    @Size(min = 10, max = 2000)
    private String facebookUrl;
    @Size(min = 10, max = 2000)
    private String instagramUrl;
    @Size(min = 10, max = 2000)
    private String youtubeUrl;
    @Size(min = 10, max = 2000)
    private String whatsappUrl;
    @Basic(optional = false)
    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public WebsiteSettings() {
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getWhatsappUrl() {
        return whatsappUrl;
    }

    public void setWhatsappUrl(String whatsappUrl) {
        this.whatsappUrl = whatsappUrl;
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

    public String getAboutImgPath() {
        return aboutImgPath;
    }

    public void setAboutImgPath(String aboutImgPath) {
        this.aboutImgPath = aboutImgPath;
    }

    public String getContactImgPath() {
        return contactImgPath;
    }

    public void setContactImgPath(String contactImgPath) {
        this.contactImgPath = contactImgPath;
    }

    @Override
    public String toString() {
        return "com.bsptech.teachermanagement.entity.WebsiteSettings[ id=" + id + " ]";
    }

}
