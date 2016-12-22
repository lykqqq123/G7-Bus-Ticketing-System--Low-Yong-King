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
 * @author limru
 */
@Entity
@Table(name = "TRANSACTION_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionDetails.findAll", query = "SELECT t FROM TransactionDetails t"),
    @NamedQuery(name = "TransactionDetails.findByTranstId", query = "SELECT t FROM TransactionDetails t WHERE t.transtId = :transtId"),
    @NamedQuery(name = "TransactionDetails.findByPaymentStatus", query = "SELECT t FROM TransactionDetails t WHERE t.paymentStatus = :paymentStatus")})
public class TransactionDetails implements Serializable {
    @Column(name = "TRANST_STATUS")
    private String transtStatus;
    @OneToMany(mappedBy = "transtId")
    private List<PaymentDetails> paymentDetailsList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRANST_ID")
    private String transtId;
    @Column(name = "PAYMENT_STATUS")
    private String paymentStatus;
    @JoinColumn(name = "SCHEDULE_ID", referencedColumnName = "SCHEDULE_ID")
    @ManyToOne
    private BusScheduleDomain scheduleId;
    @JoinColumn(name = "CUST_TYPE_ID", referencedColumnName = "CUST_TYPE_ID")
    @ManyToOne
    private CustTypeDomain custTypeId;

    public TransactionDetails() {
    }

    public TransactionDetails(String transtId, String paymentStatus, BusScheduleDomain scheduleId, CustTypeDomain custTypeId) {
        this.transtId = transtId;
        this.paymentStatus = paymentStatus;
        this.scheduleId = scheduleId;
        this.custTypeId = custTypeId;
    }

    public TransactionDetails(String transtStatus, String transtId) {
        this.transtStatus = transtStatus;
        this.transtId = transtId;
    }

    public TransactionDetails(String transtId) {
        this.transtId = transtId;
    }

    public String getTranstId() {
        return transtId;
    }

    public void setTranstId(String transtId) {
        this.transtId = transtId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BusScheduleDomain getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(BusScheduleDomain scheduleId) {
        this.scheduleId = scheduleId;
    }

    public CustTypeDomain getCustTypeId() {
        return custTypeId;
    }

    public void setCustTypeId(CustTypeDomain custTypeId) {
        this.custTypeId = custTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transtId != null ? transtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionDetails)) {
            return false;
        }
        TransactionDetails other = (TransactionDetails) object;
        if ((this.transtId == null && other.transtId != null) || (this.transtId != null && !this.transtId.equals(other.transtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.TransactionDetails[ transtId=" + transtId + " ]";
    }

    public String getTranstStatus() {
        return transtStatus;
    }

    public void setTranstStatus(String transtStatus) {
        this.transtStatus = transtStatus;
    }

    @XmlTransient
    public List<PaymentDetails> getPaymentDetailsList() {
        return paymentDetailsList;
    }

    public void setPaymentDetailsList(List<PaymentDetails> paymentDetailsList) {
        this.paymentDetailsList = paymentDetailsList;
    }
    
}
