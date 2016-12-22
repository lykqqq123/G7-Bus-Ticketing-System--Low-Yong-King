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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author waiho
 */
@Entity
@Table(name = "BUS_SCHEDULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BusSchedule.findAll", query = "SELECT b FROM BusSchedule b"),
    @NamedQuery(name = "BusSchedule.findByScheduleId", query = "SELECT b FROM BusSchedule b WHERE b.scheduleId = :scheduleId"),
    @NamedQuery(name = "BusSchedule.findByScheduleDate", query = "SELECT b FROM BusSchedule b WHERE b.scheduleDate = :scheduleDate"),
    @NamedQuery(name = "BusSchedule.findByScheduleTime", query = "SELECT b FROM BusSchedule b WHERE b.scheduleTime = :scheduleTime"),
    @NamedQuery(name = "BusSchedule.findByAvailableSeat", query = "SELECT b FROM BusSchedule b WHERE b.availableSeat = :availableSeat"),
    @NamedQuery(name = "BusSchedule.findByPrice", query = "SELECT b FROM BusSchedule b WHERE b.price = :price"),
    @NamedQuery(name = "BusSchedule.findByDepartLocation", query = "SELECT b FROM BusSchedule b WHERE b.departLocation = :departLocation"),
    @NamedQuery(name = "BusSchedule.findByArriveLocation", query = "SELECT b FROM BusSchedule b WHERE b.arriveLocation = :arriveLocation")})
public class BusScheduleDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SCHEDULE_ID")
    private String scheduleId;
    @Column(name = "SCHEDULE_DATE")
    private String scheduleDate;
    @Column(name = "SCHEDULE_TIME")
    private String scheduleTime;
    @Column(name = "AVAILABLE_SEAT")
    private Integer availableSeat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "DEPART_LOCATION")
    private String departLocation;
    @Column(name = "ARRIVE_LOCATION")
    private String arriveLocation;
    @JoinColumn(name = "BUS_ID", referencedColumnName = "BUS_ID")
    @ManyToOne
    private BusDetailsDomain busId;
    @OneToMany(mappedBy = "scheduleId")
    private List<TransactionDetails> transactionDetailsList;

    public BusScheduleDomain() {
    }

    public BusScheduleDomain(String scheduleId, String scheduleDate, String scheduleTime, Integer availableSeat, Double price, String departLocation, String arriveLocation, BusDetailsDomain busId) {
        this.scheduleId = scheduleId;
        this.scheduleDate = scheduleDate;
        this.scheduleTime = scheduleTime;
        this.availableSeat = availableSeat;
        this.price = price;
        this.departLocation = departLocation;
        this.arriveLocation = arriveLocation;
        this.busId = busId;
    }

    public BusScheduleDomain(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public Integer getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(Integer availableSeat) {
        this.availableSeat = availableSeat;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDepartLocation() {
        return departLocation;
    }

    public void setDepartLocation(String departLocation) {
        this.departLocation = departLocation;
    }

    public String getArriveLocation() {
        return arriveLocation;
    }

    public void setArriveLocation(String arriveLocation) {
        this.arriveLocation = arriveLocation;
    }

    public BusDetailsDomain getBusId() {
        return busId;
    }

    public void setBusId(BusDetailsDomain busId) {
        this.busId = busId;
    }

    @XmlTransient
    public List<TransactionDetails> getTransactionDetailsList() {
        return transactionDetailsList;
    }

    public void setTransactionDetailsList(List<TransactionDetails> transactionDetailsList) {
        this.transactionDetailsList = transactionDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (scheduleId != null ? scheduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BusScheduleDomain)) {
            return false;
        }
        BusScheduleDomain other = (BusScheduleDomain) object;
        if ((this.scheduleId == null && other.scheduleId != null) || (this.scheduleId != null && !this.scheduleId.equals(other.scheduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.BusSchedule[ scheduleId=" + scheduleId + " ]";
    }
    
}
