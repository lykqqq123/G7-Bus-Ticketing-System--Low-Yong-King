/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author limru
 */
@Entity
@Table(name = "BUS_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusDetails.findAll", query = "SELECT b FROM BusDetails b"),
    @NamedQuery(name = "BusDetails.findByBusId", query = "SELECT b FROM BusDetails b WHERE b.busId = :busId"),
    @NamedQuery(name = "BusDetails.findByBusPlateNum", query = "SELECT b FROM BusDetails b WHERE b.busPlateNum = :busPlateNum"),
    @NamedQuery(name = "BusDetails.findByBusColour", query = "SELECT b FROM BusDetails b WHERE b.busColour = :busColour"),
    @NamedQuery(name = "BusDetails.findByBusStatus", query = "SELECT b FROM BusDetails b WHERE b.busStatus = :busStatus"),
    @NamedQuery(name = "BusDetails.findByTotalSeat", query = "SELECT b FROM BusDetails b WHERE b.totalSeat = :totalSeat"),
    @NamedQuery(name = "BusDetails.findByDescription", query = "SELECT b FROM BusDetails b WHERE b.description = :description"),
    @NamedQuery(name = "BusDetails.findByBusType", query = "SELECT b FROM BusDetails b WHERE b.busType = :busType")})
public class BusDetailsDomain implements Serializable {
    @OneToMany(mappedBy = "busId")
    private List<BusScheduleDomain> busScheduleDomainList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BUS_ID")
    private String busId;
    @Column(name = "BUS_PLATE_NUM")
    private String busPlateNum;
    @Column(name = "BUS_COLOUR")
    private String busColour;
    @Column(name = "BUS_STATUS")
    private String busStatus;
    @Column(name = "TOTAL_SEAT")
    private Integer totalSeat;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "BUS_TYPE")
    private String busType;

    public BusDetailsDomain() {
    }

    public BusDetailsDomain(String busId, String busPlateNum, String busColour, String busStatus, Integer totalSeat, String description, String busType) {
        this.busId = busId;
        this.busPlateNum = busPlateNum;
        this.busColour = busColour;
        this.busStatus = busStatus;
        this.totalSeat = totalSeat;
        this.description = description;
        this.busType = busType;
    }

    public BusDetailsDomain(String busId) {
        this.busId = busId;
    }

    public String getBusId() {
        return busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getBusPlateNum() {
        return busPlateNum;
    }

    public void setBusPlateNum(String busPlateNum) {
        this.busPlateNum = busPlateNum;
    }

    public String getBusColour() {
        return busColour;
    }

    public void setBusColour(String busColour) {
        this.busColour = busColour;
    }

    public String getBusStatus() {
        return busStatus;
    }

    public void setBusStatus(String busStatus) {
        this.busStatus = busStatus;
    }

    public Integer getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(Integer totalSeat) {
        this.totalSeat = totalSeat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (busId != null ? busId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusDetailsDomain)) {
            return false;
        }
        BusDetailsDomain other = (BusDetailsDomain) object;
        if ((this.busId == null && other.busId != null) || (this.busId != null && !this.busId.equals(other.busId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DOMAIN.BusDetails[ busId=" + busId + " ]";
    }

    @XmlTransient
    public List<BusScheduleDomain> getBusScheduleDomainList() {
        return busScheduleDomainList;
    }

    public void setBusScheduleDomainList(List<BusScheduleDomain> busScheduleDomainList) {
        this.busScheduleDomainList = busScheduleDomainList;
    }
    
}
