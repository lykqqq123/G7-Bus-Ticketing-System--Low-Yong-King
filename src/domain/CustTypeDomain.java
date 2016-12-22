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
 * @author waiho
 */
@Entity
@Table(name = "CUST_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustType.findAll", query = "SELECT c FROM CustType c"),
    @NamedQuery(name = "CustType.findByCustTypeId", query = "SELECT c FROM CustType c WHERE c.custTypeId = :custTypeId"),
    @NamedQuery(name = "CustType.findByCustType", query = "SELECT c FROM CustType c WHERE c.custType = :custType"),
    @NamedQuery(name = "CustType.findByDiscountRate", query = "SELECT c FROM CustType c WHERE c.discountRate = :discountRate")})
public class CustTypeDomain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CUST_TYPE_ID")
    private String custTypeId;
    @Column(name = "CUST_TYPE")
    private String custType;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISCOUNT_RATE")
    private Double discountRate;
    @OneToMany(mappedBy = "custTypeId")
    private List<TransactionDetails> transactionDetailsList;

    public CustTypeDomain() {
    }

    public CustTypeDomain(String custTypeId, String custType, Double discountRate) {
        this.custTypeId = custTypeId;
        this.custType = custType;
        this.discountRate = discountRate;
    }

    public CustTypeDomain(String custTypeId) {
        this.custTypeId = custTypeId;
    }

    public String getCustTypeId() {
        return custTypeId;
    }

    public void setCustTypeId(String custTypeId) {
        this.custTypeId = custTypeId;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
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
        hash += (custTypeId != null ? custTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustTypeDomain)) {
            return false;
        }
        CustTypeDomain other = (CustTypeDomain) object;
        if ((this.custTypeId == null && other.custTypeId != null) || (this.custTypeId != null && !this.custTypeId.equals(other.custTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.CustType[ custTypeId=" + custTypeId + " ]";
    }
    
}
