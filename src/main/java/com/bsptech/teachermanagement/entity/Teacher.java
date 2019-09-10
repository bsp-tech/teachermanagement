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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")
    , @NamedQuery(name = "Teacher.findById", query = "SELECT t FROM Teacher t WHERE t.id = :id")
    , @NamedQuery(name = "Teacher.findByApproved", query = "SELECT t FROM Teacher t WHERE t.approved = :approved")
    , @NamedQuery(name = "Teacher.findByDepartmentId", query = "SELECT t FROM Teacher t WHERE t.departmentId = :departmentId")
    , @NamedQuery(name = "Teacher.findByExperience", query = "SELECT t FROM Teacher t WHERE t.experience = :experience")
    , @NamedQuery(name = "Teacher.findByInsertDateTime", query = "SELECT t FROM Teacher t WHERE t.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "Teacher.findByLastUpdateDateTime", query = "SELECT t FROM Teacher t WHERE t.lastUpdateDateTime = :lastUpdateDateTime")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "approved")
    private short approved;
    @Basic(optional = false)
    @NotNull
    @Column(name = "department_id")
    private int departmentId;
    @Size(max = 255)
    @Column(name = "experience")
    private String experience;
    @Basic(optional = false)
    @NotNull
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId", fetch = FetchType.LAZY)
    private List<Exam> examList;
    @OneToMany(mappedBy = "teacherId", fetch = FetchType.LAZY)
    private List<TeacherStudent> teacherStudentList;

    public Teacher() {
    }

    public Teacher(Integer id) {
        this.id = id;
    }

    public Teacher(Integer id, short approved, int departmentId, Date insertDateTime) {
        this.id = id;
        this.approved = approved;
        this.departmentId = departmentId;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getApproved() {
        return approved;
    }

    public void setApproved(short approved) {
        this.approved = approved;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
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

    @XmlTransient
    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    @XmlTransient
    public List<TeacherStudent> getTeacherStudentList() {
        return teacherStudentList;
    }

    public void setTeacherStudentList(List<TeacherStudent> teacherStudentList) {
        this.teacherStudentList = teacherStudentList;
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
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.teachermanagement.entity.Teacher[ id=" + id + " ]";
    }
    
}
