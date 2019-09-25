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
@Table(name = "support")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Support.findAll", query = "SELECT s FROM Support s")
    , @NamedQuery(name = "Support.findById", query = "SELECT s FROM Support s WHERE s.id = :id")
    , @NamedQuery(name = "Support.findByFullname", query = "SELECT s FROM Support s WHERE s.fullname = :fullname")
    , @NamedQuery(name = "Support.findByEmail", query = "SELECT s FROM Support s WHERE s.email = :email")
    , @NamedQuery(name = "Support.findBySubject", query = "SELECT s FROM Support s WHERE s.subject = :subject")
    , @NamedQuery(name = "Support.findByMessage", query = "SELECT s FROM Support s WHERE s.message = :message")
    , @NamedQuery(name = "Support.findByInsertDateTime", query = "SELECT s FROM Support s WHERE s.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "Support.findBySolvedDateTime", query = "SELECT s FROM Support s WHERE s.solvedDateTime = :solvedDateTime")})
public class Support implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fullname")
    private String fullname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "solved_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date solvedDateTime;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Status statusId;
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Department departmentId;

    public Support() {
    }

    public Support(Integer id) {
        this.id = id;
    }

    public Support(Integer id, String fullname, String email, String subject, String message, Date insertDateTime) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getSolvedDateTime() {
        return solvedDateTime;
    }

    public void setSolvedDateTime(Date solvedDateTime) {
        this.solvedDateTime = solvedDateTime;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
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
        if (!(object instanceof Support)) {
            return false;
        }
        Support other = (Support) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.teachermanagement.entity.Support[ id=" + id + " ]";
    }
    
}
