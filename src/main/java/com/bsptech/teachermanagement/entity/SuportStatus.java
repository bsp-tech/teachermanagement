/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.teachermanagement.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "suport_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SuportStatus.findAll", query = "SELECT s FROM SuportStatus s")
    , @NamedQuery(name = "SuportStatus.findById", query = "SELECT s FROM SuportStatus s WHERE s.id = :id")
    , @NamedQuery(name = "SuportStatus.findByStatusId", query = "SELECT s FROM SuportStatus s WHERE s.statusId = :statusId")})
public class SuportStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_id")
    private int statusId;
    @JoinColumn(name = "support_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Support supportId;

    public SuportStatus() {
    }

    public SuportStatus(Integer id) {
        this.id = id;
    }

    public SuportStatus(Integer id, int statusId) {
        this.id = id;
        this.statusId = statusId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Support getSupportId() {
        return supportId;
    }

    public void setSupportId(Support supportId) {
        this.supportId = supportId;
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
        if (!(object instanceof SuportStatus)) {
            return false;
        }
        SuportStatus other = (SuportStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.teachermanagement.entity.SuportStatus[ id=" + id + " ]";
    }
    
}
