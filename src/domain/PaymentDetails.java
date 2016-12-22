/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author limru
 */
@Entity
@Table(name = "PAYMENT_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentDetails.findAll", query = "SELECT p FROM PaymentDetails p"),
    @NamedQuery(name = "PaymentDetails.findByPaycountId", query = "SELECT p FROM PaymentDetails p WHERE p.paycountId = :paycountId"),
    @NamedQuery(name = "PaymentDetails.findByPaymentId", query = "SELECT p FROM PaymentDetails p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "PaymentDetails.findByPaymentDate", query = "SELECT p FROM PaymentDetails p WHERE p.paymentDate = :paymentDate"),
    @NamedQuery(name = "PaymentDetails.findByPaymentTime", query = "SELECT p FROM PaymentDetails p WHERE p.paymentTime = :paymentTime"),
    @NamedQuery(name = "PaymentDetails.findByPaymentType", query = "SELECT p FROM PaymentDetails p WHERE p.paymentType = :paymentType"),
    @NamedQuery(name = "PaymentDetails.findByTotalAmount", query = "SELECT p FROM PaymentDetails p WHERE p.totalAmount = :totalAmount")})
public class PaymentDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAYCOUNT_ID")
    private String paycountId;
    @Column(name = "PAYMENT_ID")
    private String paymentId;
    @Column(name = "PAYMENT_DATE")
    private String paymentDate;
    @Column(name = "PAYMENT_TIME")
    private String paymentTime;
    @Column(name = "PAYMENT_TYPE")
    private String paymentType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL_AMOUNT")
    private Double totalAmount;
    @JoinColumn(name = "STAFF_ID", referencedColumnName = "STAFF_ID")
    @ManyToOne
    private Staff staffId;
    @JoinColumn(name = "TRANST_ID", referencedColumnName = "TRANST_ID")
    @ManyToOne
    private TransactionDetails transtId;

    public PaymentDetails() {
    }

    public PaymentDetails(String paycountId, String paymentId, String paymentDate, String paymentTime, String paymentType, Double totalAmount, TransactionDetails transtId, Staff staffId) {
        this.paycountId = paycountId;
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentTime = paymentTime;
        this.paymentType = paymentType;
        this.totalAmount = totalAmount;
        this.staffId = staffId;
        this.transtId = transtId;
    }

    public PaymentDetails(String paycountId) {
        this.paycountId = paycountId;
    }



    public String getPaycountId() {
        return paycountId;
    }

    public void setPaycountId(String paycountId) {
        this.paycountId = paycountId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public TransactionDetails getTranstId() {
        return transtId;
    }

    public void setTranstId(TransactionDetails transtId) {
        this.transtId = transtId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paycountId != null ? paycountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDetails)) {
            return false;
        }
        PaymentDetails other = (PaymentDetails) object;
        if ((this.paycountId == null && other.paycountId != null) || (this.paycountId != null && !this.paycountId.equals(other.paycountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PaymentDetails[ paycountId=" + paycountId + " ]";
    }
    
}
