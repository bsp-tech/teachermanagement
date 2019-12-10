/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.entity;

import java.io.Serializable;
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
@Table(name = "faq")
@XmlRootElement
public class FAQ implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "header")
    private String header;
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "content")
    private String content;
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;

    public FAQ(Integer id, @NotNull @Size(min = 1, max = 255) String header, @NotNull @Size(min = 1, max = 2000) String content, Date insertDateTime, Date lastUpdateDateTime) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.insertDateTime = insertDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public FAQ() {
    }

    @Override
    public String toString() {
        return "FAQ{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", insertDateTime=" + insertDateTime +
                ", lastUpdateDateTime=" + lastUpdateDateTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
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

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

}
